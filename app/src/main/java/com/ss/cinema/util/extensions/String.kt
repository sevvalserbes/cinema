package com.ss.cinema.util.extensions

import android.annotation.SuppressLint
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@SuppressLint("NewApi")
fun String.yearToString(): String {
    val dateFormat = DateTimeFormatter.ISO_DATE
    val localDate = LocalDate.parse(this, dateFormat)
    return localDate.year.toString()
}