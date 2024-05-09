package com.example.mealzapp.ui.meals

import androidx.lifecycle.ViewModel
import com.example.mealzapp.model.MealsRepository
import com.example.mealzapp.model.response.MealResponse
import com.example.mealzapp.model.response.MealsCategoriesResponse
import retrofit2.Callback

class MealsCategoriesViewModel(private val repository: MealsRepository= MealsRepository()):ViewModel() {
    fun getMeals(successCallback: (response:MealsCategoriesResponse?)->Unit){
     repository.getMeals(){response ->
         successCallback(response)
     }
    }
}