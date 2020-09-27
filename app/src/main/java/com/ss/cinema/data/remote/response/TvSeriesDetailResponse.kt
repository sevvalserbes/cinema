package com.ss.cinema.data.remote.response

import com.google.gson.annotations.SerializedName

data class TvSeriesDetailResponse(
    @SerializedName("original_name")
    val originalName: String?,
    @SerializedName("overview")
    val overview: String?,
    @SerializedName("vote_average")
    val voteAverage: Number?,
    @SerializedName("vote_count")
    val voteCount: Int?,
    @SerializedName("poster_path")
    val posterPath: String?,
)