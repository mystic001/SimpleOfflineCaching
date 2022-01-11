package com.example.simpleofflinecaching.feature.restsurants

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.simpleofflinecaching.api.RestaurantApi
import com.example.simpleofflinecaching.data.Restaurant
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class RestaurantViewModel @Inject constructor(api:RestaurantApi):ViewModel() {


    private val restaurantlivedata = MutableLiveData<List<Restaurant>>()

    public val restaurants: LiveData<List<Restaurant>> = restaurantlivedata
    init{
       viewModelScope.launch {
           val restaurantdata = api.getRestaurant()
           restaurantlivedata.value = api.getRestaurant()
       }
    }
}