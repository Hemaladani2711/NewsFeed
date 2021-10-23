package com.home.newsfeed.ui

import Component
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.home.newsfeed.MainViewModel
import com.home.newsfeed.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Holds only UI related logic of displaying
 * NewsFeed
 * */
class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var newsFeedAdapter: NewsFeedAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView=findViewById(R.id.recyclerview)

        viewModel=ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.getFeed().observe(this,{
            displayUserData(it)
        })


    }
    private fun displayUserData(feed:List<Component>){
        recyclerView.layoutManager = LinearLayoutManager(this)
        newsFeedAdapter= NewsFeedAdapter(feed)
        recyclerView.adapter=newsFeedAdapter
    }
}