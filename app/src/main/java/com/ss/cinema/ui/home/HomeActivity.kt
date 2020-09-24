package com.ss.cinema.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.ss.cinema.R
import com.ss.cinema.databinding.ActivityHomeBinding
import com.ss.cinema.ui.movies.MoviesFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        setButtomNavigationBar()
    }

    fun setButtomNavigationBar() {
        val navController = findNavController(R.id.fragment_nav_host)
        binding.bottomNavigationView.setupWithNavController(navController)
    }
}