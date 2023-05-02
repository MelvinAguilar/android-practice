package com.melvin.a04_navigation_component.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.melvin.a04_navigation_component.R
import com.melvin.a04_navigation_component.databinding.ActivityMainBinding
import com.melvin.a04_navigation_component.ui.movie.FormAddMovieFragment
import com.melvin.a04_navigation_component.ui.movie.MovieViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil
            .setContentView(this, R.layout.activity_main)

        supportActionBar!!.hide()
    }
}