package com.example.simpleofflinecaching.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface RestaurantDao {



    @Query("SELECT * FROM restaurant")
    fun getAllRestaurant():Flow<List<Restaurant>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRestaurant(restaurant: List<Restaurant>);


    @Query("DELETE FROM restaurant")
    suspend fun deleteAllRestaurant()



}