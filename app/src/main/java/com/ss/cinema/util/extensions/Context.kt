package com.ss.cinema.util.extensions

import android.content.Context
import android.widget.Toast

fun Context.showToast(message: String, length: Int) {
    Toast.makeText(
        this,
        message,
        length
    ).show()
}