package com.ss.cinema.domain.mapper

import com.ss.cinema.data.remote.response.BaseResponse
import com.ss.cinema.data.remote.response.MultiSearchResponse
import com.ss.cinema.domain.model.MultiSearch
import com.ss.cinema.util.MediaType
import javax.inject.Inject

class MultiSearchMapper @Inject constructor() :
    Mapper<BaseResponse<MultiSearchResponse>, List<MultiSearch>> {
    override fun mapFrom(response: BaseResponse<MultiSearchResponse>): List<MultiSearch> {
        return response.results?.map { multiSearchResponse ->
            MultiSearch(
                id = multiSearchResponse.id ?: 0,
                mediaType = getMediaType(multiSearchResponse.mediaType),
                posterPath = multiSearchResponse.posterPath.orEmpty(),
                profilePath = multiSearchResponse.profilePath.orEmpty(),
                originalTitle = multiSearchResponse.originalTitle.orEmpty(),
                originalName = multiSearchResponse.originalName.orEmpty(),
                name = multiSearchResponse.name.orEmpty()
            )
        } ?: listOf()
    }

    private fun getMediaType(mediaType: String?): MediaType {
        return when (mediaType) {
            TYPE_MOVIE -> MediaType.MOVIE
            TYPE_TV -> MediaType.TV
            TYPE_PERSON -> MediaType.PERSON
            else -> MediaType.UNKNOWN
        }
    }

    companion object {
        const val TYPE_MOVIE = "movie"
        const val TYPE_TV = "tv"
        const val TYPE_PERSON = "person"
    }
}