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
    private var imdbID: String? = null
    private var movieDetail: MovieDetail? = null

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

        imdbID = intent.getStringExtra("imdbID")

        if (imdbID != null) loadMovieDetail(imdbID!!)
    }

    private fun loadMovieDetail(imdbID: String) {
        thread {
            val response = ApiService.getMovieDetail(imdbID)
            if (response != null) {
                val detail = Gson().fromJson(response, MovieDetail::class.java)
                movieDetail = detail

                runOnUiThread {
                    tvTitle.text = detail.Title
                    tvYear.text = "Año: ${detail.Year}"
                    tvRuntime.text = "Duración: ${detail.Runtime}"
                    tvGenre.text = "Género: ${detail.Genre}"
                    tvDirector.text = "Director: ${detail.Director}"
                    tvCountry.text = "País: ${detail.Country}"
                    tvPlot.text = "Sinopsis: ${detail.Plot}"
                    Picasso.get().load(detail.Poster).into(ivPosterDetail)

                }
            }
        }
    }

}
