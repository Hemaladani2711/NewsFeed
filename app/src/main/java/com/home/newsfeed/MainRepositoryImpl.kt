package com.home.newsfeed

import Component
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.*

/**
 * MainRepository behaves as model layer for
 * MainActivity. Makes network or database calls and
 * retrives data.
 * */
class MainRepositoryImpl(private val coroutineScope:CoroutineScope, private val data:MutableLiveData<List<Component>> = MutableLiveData()):MainRepository{

   override fun downloadFeed(){
        coroutineScope.launch {
            val feed = MockClientNew.getFeed()
            withContext(Dispatchers.Main){
                data.postValue(feed)
            }
        }
    }

    override fun getFeed(): LiveData<List<Component>>{
      return data
    }
}