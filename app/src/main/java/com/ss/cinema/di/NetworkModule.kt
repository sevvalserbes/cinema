package com.ss.cinema.di

import com.facebook.stetho.okhttp3.StethoInterceptor
import com.ss.cinema.data.remote.RequestInterceptor
import com.ss.cinema.data.remote.api.MovieService
import com.ss.cinema.data.remote.api.TvSeriesService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {
    @Provides
    fun provideOkHttpClient(): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(RequestInterceptor())
            .addNetworkInterceptor(StethoInterceptor())
            .build()

    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .client(okHttpClient)
            .build()

    @Provides
    fun provideMovieService(retrofit: Retrofit): MovieService {
        return retrofit.create()
    }

    @Provides
    fun provideTvSeriesService(retrofit: Retrofit): TvSeriesService {
        return retrofit.create()
    }
}