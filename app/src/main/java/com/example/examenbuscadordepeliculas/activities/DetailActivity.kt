package com.example.examenbuscadordepeliculas.activities

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.examenbuscadordepeliculas.R
import com.example.examenbuscadordepeliculas.data.MovieDetail
import com.example.examenbuscadordepeliculas.utils.ApiService
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import kotlin.concurrent.thread

class DetailActivity : AppCompatActivity() {

    private lateinit var ivPosterDetail: ImageView
    private lateinit var tvTitle: TextView
    private lateinit var tvYear: TextView
    private lateinit var tvRuntime: TextView
    private lateinit var tvGenre: TextView
    private lateinit var tvDirector: TextView
    private lateinit var tvCountry: TextView
    private lateinit var tvPlot: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        ivPosterDetail = findViewById(R.id.ivPosterDetail)
        tvTitle = findViewById(R.id.tvTitle)
        tvYear = findViewById(R.id.tvYear)
        tvRuntime = findViewById(R.id.tvRuntime)
        tvGenre = findViewById(R.id.tvGenre)
        tvDirector = findViewById(R.id.tvDirector)
        tvCountry = findViewById(R.id.tvCountry)
        tvPlot = findViewById(R.id.tvPlot)

        val imdbID = intent.getStringExtra("imdbID")
        if (imdbID != null) loadMovieDetail(imdbID)
    }

    private fun loadMovieDetail(imdbID: String) {
        thread {
            val response = ApiService.getMovieDetail(imdbID)
            if (response != null) {
                val movieDetail = Gson().fromJson(response, MovieDetail::class.java)
                runOnUiThread {
                    tvTitle.text = movieDetail.Title
                    tvYear.text = "Año: ${movieDetail.Year}"
                    tvRuntime.text = "Duración: ${movieDetail.Runtime}"
                    tvGenre.text = "Género: ${movieDetail.Genre}"
                    tvDirector.text = "Director: ${movieDetail.Director}"
                    tvCountry.text = "País: ${movieDetail.Country}"
                    tvPlot.text = "Sinopsis: ${movieDetail.Plot}"
                    Picasso.get().load(movieDetail.Poster).into(ivPosterDetail)
                }
            }
        }
    }
}
