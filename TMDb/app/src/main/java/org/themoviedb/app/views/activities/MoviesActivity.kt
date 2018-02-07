package org.themoviedb.app.views.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import org.themoviedb.app.R

class MoviesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies)
    }

}