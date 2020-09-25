package com.ss.cinema.data.remote.response

import com.google.gson.annotations.SerializedName

data class TvSeriesResponse(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("original_name")
    val originalName: String?,
    @SerializedName("poster_path")
    val posterPath: String?,
    @SerializedName("genre_ids")
    val genreIds: List<Int>?,
    @SerializedName("vote_average")
    val voteAverage: Number?,
    @SerializedName("first_air_date")
    val firstAirDate: String?
)