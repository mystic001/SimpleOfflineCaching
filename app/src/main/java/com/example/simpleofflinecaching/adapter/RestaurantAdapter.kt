package com.example.simpleofflinecaching.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import androidx.recyclerview.widget.DiffUtil

import androidx.recyclerview.widget.RecyclerView
import com.example.simpleofflinecaching.R
import com.example.simpleofflinecaching.data.Restaurant

class RestaurantAdapter(private val restaurantList: MutableList<Restaurant>): RecyclerView.Adapter<RestaurantAdapter.RestaurantHolder>() {


    class RestaurantHolder(itemView: View):RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantHolder {
        val restaurantView = LayoutInflater.from(parent.context).inflate(R.layout.standardview, parent, false)
        return RestaurantHolder(restaurantView);
    }

    override fun onBindViewHolder(holder: RestaurantHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    class RestaurantComparator: DiffUtil.ItemCallback<Restaurant>(){
        override fun areItemsTheSame(oldItem: Restaurant, newItem: Restaurant): Boolean {
            if(oldItem.name == newItem.name){
                return true
            }

            return false;
        }

        override fun areContentsTheSame(oldItem: Restaurant, newItem: Restaurant): Boolean {
            TODO("Not yet implemented")
        }

    }
}