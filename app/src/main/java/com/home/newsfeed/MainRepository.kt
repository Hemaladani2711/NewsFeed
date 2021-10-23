package com.home.newsfeed

import Component
import androidx.lifecycle.LiveData

interface MainRepository {
   fun getFeed():LiveData<List<Component>>
   fun downloadFeed()
}