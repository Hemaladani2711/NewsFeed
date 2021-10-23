package com.home.newsfeed.ui

import Component
import Component1
import Component2
import Component3
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.home.newsfeed.R

class NewsFeedAdapter(val items:List<Component>):
    RecyclerView.Adapter<NewsFeedAdapter.ViewHolder>() {

    inner class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val txtFeed:TextView = itemView.findViewById(R.id.txt_feed)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return ViewHolder(view)
    }
    /**
     * BindViewHolder checks if instance is of type
     * Component1,Component2 or Component3. Populates
     * data accordingly. Same view is used for rendering
     * data.
     * */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val item = items[position]
            if(item is Component1){
                holder.txtFeed.text=item.text
            }else if(item is Component2){
                holder.txtFeed.text=item.imageUrl
            }else if(item is Component3){
                holder.txtFeed.text=item.timestamp.toString()
            }
    }
    override fun getItemCount()=items.size

}