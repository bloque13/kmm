package com.example.myapplication.presentation.recipe_detail

import com.example.myapplication.domain.util.Queue
import com.example.myapplication.domain.model.GenericMessageInfo
import com.example.myapplication.domain.model.Recipe

data class RecipeDetailState(
    val isLoading: Boolean = false,
    val recipe: Recipe? = null,
    val queue: Queue<GenericMessageInfo> = Queue(mutableListOf()), // messages to be displayed in ui
){
    // Need secondary constructor to initialize with no args in SwiftUI
    constructor(): this(
        isLoading = false,
        recipe = null,
        queue = Queue(mutableListOf()),
    )
}


