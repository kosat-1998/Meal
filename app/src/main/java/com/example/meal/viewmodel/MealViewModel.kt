package com.example.meal.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.meal.api.MealApi
import com.example.meal.model.Category
import com.example.meal.model.Meal
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MealViewModel : ViewModel(){


    var result : MutableLiveData<List<Category>> = MutableLiveData()      //setter
    fun getMeal() : LiveData<List<Category>> = result                     // getter

    private val mealApi:MealApi = MealApi()             //create object MealApi

        // calling Rest Api or loading result from Rest Api


    fun loadMeal(){

        val apiCall = mealApi.getMeal()
        apiCall.enqueue(object : Callback<Meal>{
            override fun onFailure(call: Call<Meal>, t: Throwable) {
                TODO("Not yet implemented")
            }

            override fun onResponse(call: Call<Meal>, response: Response<Meal>) {

                response.isSuccessful.let {
                    val resultList = response.body()?.categories ?: emptyList()
                    result.value = resultList
                }

            }

        })


    }

}