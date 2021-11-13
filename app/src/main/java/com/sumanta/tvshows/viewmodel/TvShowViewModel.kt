package com.sumanta.tvshows.viewmodel

import android.content.Context
import android.nfc.Tag
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sumanta.tvshows.model.TvShowResponse
import com.sumanta.tvshows.model.TvShowResponseItem
import com.sumanta.tvshows.repo.TvShowRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.math.log

@HiltViewModel
class TvShowViewModel
@Inject
constructor(private val tvShowRepository: TvShowRepository) : ViewModel() {

    private val responseLiveData = MutableLiveData<List<TvShowResponseItem>>()

    val responseTvShow: LiveData<List<TvShowResponseItem>>
        get() = responseLiveData


    init {
        getAllTvShows()
    }

    private fun getAllTvShows() = viewModelScope.launch {
        tvShowRepository.getTvShows().let { response ->
            if (response.isSuccessful) {
                responseLiveData.postValue(response.body())
            } else {
                Log.d("tag", "getAllTvShow ${response.code()}")
            }
        }
    }


}