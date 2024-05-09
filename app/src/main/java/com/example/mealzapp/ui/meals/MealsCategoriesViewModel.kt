package com.example.mealzapp.ui.meals

import androidx.lifecycle.ViewModel
import com.example.mealzapp.model.MealsRepository
import com.example.mealzapp.model.response.MealResponse

class MealsCategoriesViewModel(private val repository: MealsRepository= MealsRepository()):ViewModel() {
    fun getMeals():List<MealResponse>{
     return   repository.getMeals().categories
    }
}