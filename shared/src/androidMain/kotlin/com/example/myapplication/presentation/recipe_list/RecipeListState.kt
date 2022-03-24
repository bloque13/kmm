package com.example.myapplication.presentation.recipe_list

import com.example.myapplication.domain.model.GenericMessageInfo
import com.example.myapplication.domain.model.Recipe
import com.example.myapplication.domain.util.Queue

actual data class RecipeListState(
    val isLoading: Boolean = false,
    val page: Int = 1,
    val query: String = "",
    val selectedCategory: FoodCategory? = null,
    val recipes: List<Recipe> = listOf(),
    val queue: Queue<GenericMessageInfo> = Queue(mutableListOf()), // messages to be displayed in ui
)

