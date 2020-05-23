package com.example.meal.api

import com.example.meal.model.Meal
import retrofit2.Call
import retrofit2.http.GET

interface MealApiInterface {

    @GET("categories.php")
    fun getMeal() : Call<Meal>

}