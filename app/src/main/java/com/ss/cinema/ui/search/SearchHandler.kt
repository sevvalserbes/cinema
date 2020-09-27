package com.ss.cinema.ui.search

import com.ss.cinema.util.MediaType

interface SearchHandler {

    fun onSearchItemClick(itemId: Int, mediaType: MediaType)
}