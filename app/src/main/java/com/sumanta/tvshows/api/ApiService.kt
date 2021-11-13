package com.sumanta.tvshows.api

import com.sumanta.tvshows.helper.constants
import com.sumanta.tvshows.model.TvShowResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET(constants.END_POINT)
    suspend fun getTvShows(): Response<TvShowResponse>
}