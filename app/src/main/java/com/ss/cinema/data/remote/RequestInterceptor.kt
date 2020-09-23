package com.ss.cinema.data.remote

import com.ss.cinema.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RequestInterceptor @Inject constructor() : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {

        val request = chain.request()
        val httpUrl = request.url.newBuilder()
            .addQueryParameter(API_KEY_QUERY, BuildConfig.TMDB_API_KEY)
            .build()
        val requestBuilder = request.newBuilder().url(httpUrl)

        return chain.proceed(requestBuilder.build())
    }

    companion object {
        const val API_KEY_QUERY = "api_key"
    }
}