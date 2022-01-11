package com.example.simpleofflinecaching.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.simpleofflinecaching.data.Restaurant
import com.example.simpleofflinecaching.databinding.StandardviewBinding

class RestaurantAdapterList: ListAdapter<Restaurant, RestaurantAdapterList.RestaurantHandle>(RestaurantComparator()) {




    class RestaurantHandle(private val binding:StandardviewBinding) :RecyclerView.ViewHolder(binding.root){
       fun bind(restaurant: Restaurant){
           binding.apply {
               Glide.with(container)
                   .load(restaurant.logo)
                   .into(imageView)

               textViewname.text = restaurant.name;
               textViewType.text = restaurant.type;
               textView3.text = restaurant.address
           }
       }


    }
    class RestaurantComparator: DiffUtil.ItemCallback<Restaurant>(){
        override fun areItemsTheSame(oldItem: Restaurant, newItem: Restaurant): Boolean {
            if(oldItem.name == newItem.name){
                return true
            }

            return false;
        }

        override fun areContentsTheSame(oldItem: Restaurant, newItem: Restaurant): Boolean {
            if(oldItem == newItem){
                return true
            }

            return false;
        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RestaurantHandle {
       val binding = StandardviewBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return RestaurantHandle(binding)
    }

    override fun onBindViewHolder(holder: RestaurantHandle, position: Int) {
        val restaurant = getItem(position)
        holder.bind(restaurant)
    }

}