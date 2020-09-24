package com.ss.cinema.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
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
        initViewPager()
    }

    private fun initViewPager() {
        val fragment = MoviesFragment.newInstance()
        supportFragmentManager
            .beginTransaction()
            .run {
                add(R.id.frame_layout_container, fragment)
                commit()
            }
        return
    }
}