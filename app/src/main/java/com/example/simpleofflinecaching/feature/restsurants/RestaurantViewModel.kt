package com.example.simpleofflinecaching.feature.restsurants

import androidx.lifecycle.*
import com.example.simpleofflinecaching.api.RestaurantApi
import com.example.simpleofflinecaching.data.Restaurant
import com.example.simpleofflinecaching.data.RestaurantRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class RestaurantViewModel @Inject constructor(restaurantRepository: RestaurantRepository):ViewModel() {

      val restaurantFromRepo = restaurantRepository.getRestaurants().asLiveData()
//    private val restaurantlivedata = MutableLiveData<List<Restaurant>>()

//    public val restaurants: LiveData<List<Restaurant>> = restaurantlivedata
//    init{
//       viewModelScope.launch {
//           val restaurantdata = api.getRestaurant()
//           restaurantlivedata.value = api.getRestaurant()
//       }
//    }
}