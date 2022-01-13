package com.example.simpleofflinecaching.data

import androidx.room.withTransaction
import com.example.simpleofflinecaching.api.RestaurantApi
import com.example.simpleofflinecaching.util.networkBoundResource
import javax.inject.Inject

class RestaurantRepository @Inject constructor(
    private val api: RestaurantApi,
    private val db: RestaurantDatabase
) {

    val restaurantDao = db.restaurantDao();
    fun getRestaurants() = networkBoundResource(query = {
        restaurantDao.getAllRestaurant()
    }, fetch = {
        api.getRestaurant()
    }, saveFetchResult = { restaurants ->
        db.withTransaction {
            restaurantDao.deleteAllRestaurant()
            restaurantDao.insertRestaurant(restaurants)
        }

    })
}