package com.example.myreceipeapp

import androidx.compose.runtime.R
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel :  ViewModel(){




    private  val _categorieState = mutableStateOf(RecipeState())
    val categoriesState: State<RecipeState> = _categorieState

    init {
        fetchCategory()
    }

    private fun fetchCategory(){
        viewModelScope.launch {
            try {
                val response = recipeService.getCategories()
                _categorieState.value = _categorieState.value.copy(
                    loading = false,
                    list = response.categories,
                    error = null
                )

            }catch (e: Exception){
                _categorieState.value = _categorieState.value.copy(
                    loading = false,
                    error="Error fetching Categories ${e.message}")

            }

        }


    }

    data class RecipeState(
        val loading: Boolean= true,
        val list: List<category> = emptyList(),
        val error: String? = null

    )
}