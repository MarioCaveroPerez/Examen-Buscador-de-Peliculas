package com.example.examenbuscadordepeliculas.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.examenbuscadordepeliculas.adapters.MovieAdapter
import com.example.examenbuscadordepeliculas.data.MovieResponse
import com.example.examenbuscadordepeliculas.databinding.ActivityMainBinding
import com.example.examenbuscadordepeliculas.utils.ApiService
import com.google.gson.Gson
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    private lateinit var etSearch: EditText
    private lateinit var btnSearch: Button
    private lateinit var rvMovies: RecyclerView
    private lateinit var adapter: MovieAdapter

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        etSearch = binding.etSearch
        btnSearch = binding.btnSearch
        rvMovies = binding.rvMovies

        rvMovies.layoutManager = LinearLayoutManager(this)

        btnSearch.setOnClickListener {
            val query = etSearch.text.toString().trim()
            if (query.isNotEmpty()) searchMovies(query)
        }
        val handler = android.os.Handler()
        val runnable = object : Runnable {
            var visible = true
            override fun run() {
                binding.tvLoading.alpha = if (visible) 1f else 0.4f
                visible = !visible
                handler.postDelayed(this, 600)
            }
        }
        handler.post(runnable)
    }

    private fun searchMovies(query: String) {
        runOnUiThread {
            binding.tvLoading.visibility = View.VISIBLE
            binding.rvMovies.visibility = View.GONE
        }

        thread {
            val response = ApiService.searchMovies(query)
            if (response != null) {
                val movieResponse = Gson().fromJson(response, MovieResponse::class.java)
                runOnUiThread {
                    binding.tvLoading.visibility = View.GONE
                    binding.rvMovies.visibility = View.VISIBLE

                    if (movieResponse.Response == "True" && movieResponse.Search != null) {
                        adapter = MovieAdapter(movieResponse.Search) { movie ->
                            val intent = Intent(this, DetailActivity::class.java)
                            intent.putExtra("imdbID", movie.imdbID)
                            startActivity(intent)
                        }
                        binding.rvMovies.adapter = adapter
                    } else {
                        Toast.makeText(this, "No se encontraron resultados", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

}
