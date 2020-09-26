package com.ss.cinema.data.remote.response

import com.google.gson.annotations.SerializedName

data class MultiSearchResponse(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("media_type")
    val mediaType: String?,
    @SerializedName("poster_path")
    val posterPath: String?,
    @SerializedName("profile_path")
    val profilePath: String?,
    @SerializedName("original_title")
    val originalTitle: String?,
    @SerializedName("original_name")
    val originalName: String?,
    @SerializedName("name")
    val name: String?,
)