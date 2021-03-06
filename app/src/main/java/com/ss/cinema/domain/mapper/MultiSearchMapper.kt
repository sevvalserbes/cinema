package com.ss.cinema.domain.mapper

import com.ss.cinema.data.remote.response.BaseResponse
import com.ss.cinema.data.remote.response.MultiSearchResponse
import com.ss.cinema.domain.model.MultiSearch
import com.ss.cinema.util.mediatype.MediaTypeDecider
import javax.inject.Inject

class MultiSearchMapper @Inject constructor(private val decider: MediaTypeDecider) :
    Mapper<BaseResponse<MultiSearchResponse>, List<MultiSearch>> {
    override fun mapFrom(response: BaseResponse<MultiSearchResponse>): List<MultiSearch> {
        return response.results?.map { multiSearchResponse ->
            MultiSearch(
                id = multiSearchResponse.id ?: 0,
                mediaType = decider.getMediaType(multiSearchResponse.mediaType),
                posterPath = multiSearchResponse.posterPath.orEmpty(),
                profilePath = multiSearchResponse.profilePath.orEmpty(),
                originalTitle = multiSearchResponse.originalTitle.orEmpty(),
                originalName = multiSearchResponse.originalName.orEmpty(),
                name = multiSearchResponse.name.orEmpty()
            )
        } ?: listOf()
    }
}