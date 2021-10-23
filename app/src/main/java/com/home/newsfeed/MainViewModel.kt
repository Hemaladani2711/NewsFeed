package com.home.newsfeed

import Component
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel


/**
 * MainViewModel holds business logic related to views in
 * MainActivity and communicates
 * with Repository.
 * */
class MainViewModel(private val coroutineScope: CoroutineScope= CoroutineScope(Dispatchers.IO),
                    private val mainRepository: MainRepository =MainRepositoryImpl(coroutineScope)): ViewModel() {

    init {
        mainRepository.downloadFeed()
    }
    fun getFeed():LiveData<List<Component>> = mainRepository.getFeed()

    override fun onCleared() {
        super.onCleared()
        coroutineScope.cancel()
    }

}