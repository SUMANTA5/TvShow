package com.sumanta.tvshows.repo

import com.sumanta.tvshows.api.ApiService
import javax.inject.Inject

class TvShowRepository
@Inject
constructor(private val apiService : ApiService){

    suspend fun getTvShows() = apiService.getTvShows()

}