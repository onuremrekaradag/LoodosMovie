package com.kefelon.loodosmovie.data.remote.services

import com.kefelon.loodosmovie.BuildConfig
import com.kefelon.loodosmovie.data.model.MovieListResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface OMDBApiService {
    @GET(BuildConfig.API_URL)
    fun getMovies(
        @Query("apiKey") apiKey: String = BuildConfig.API_KEY,
        @Query("s") searchQuery: String
    ): Single<MovieListResponse>
}