package com.ss.cinema.util

import androidx.annotation.DrawableRes
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.ss.cinema.R

object BindingAdapter {

    @JvmStatic
    @BindingAdapter("imageUrl")
    fun loadImage(imageView: AppCompatImageView, posterPath: String?) {
        val imageUrl = "https://image.tmdb.org/t/p/w500$posterPath"
        Glide.with(imageView.context)
            .load(imageUrl)
            .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
            .placeholder(R.drawable.image_placeholder)
            .into(imageView)
    }

    @JvmStatic
    @BindingAdapter("icon")
    fun setDrawable(imageView: AppCompatImageView, @DrawableRes drawableRes: Int) {
        imageView.setImageResource(drawableRes)
    }
}