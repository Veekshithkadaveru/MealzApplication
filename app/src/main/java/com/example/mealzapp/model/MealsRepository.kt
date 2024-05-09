package com.example.mealzapp.model

import com.example.mealzapp.model.response.MealsCategoriesResponse

class MealsRepository {
    fun getMeals():MealsCategoriesResponse= MealsCategoriesResponse(arrayListOf())
}