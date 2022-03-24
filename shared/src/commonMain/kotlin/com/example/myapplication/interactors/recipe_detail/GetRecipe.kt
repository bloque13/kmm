package com.example.myapplication.interactors.recipe_detail

import com.example.myapplication.domain.model.GenericMessageInfo
import com.example.myapplication.domain.model.Recipe
import com.example.myapplication.domain.model.UIComponentType
import com.example.myapplication.domain.util.CommonFlow
import com.example.myapplication.domain.util.DataState
import com.example.myapplication.domain.util.asCommonFlow
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * Retrieve a recipe from the cache given it's unique id.
 */
class GetRecipe (
//    private val recipeCache: RecipeCache,
){
    fun execute(
        recipeId: Int,
    ): CommonFlow<DataState<Recipe>> = flow {
        try {
            emit(DataState.loading())

            // for testing
            delay(1000)

           // val recipe =  recipeCache.get(recipeId)

//            emit(DataState.data(message = null, data = recipe))

        }catch (e: Exception){
            emit(DataState.error<Recipe>(
                message = GenericMessageInfo.Builder()
                    .id("GetRecipe.Error")
                    .title("Error")
                    .uiComponentType(UIComponentType.Dialog)
                    .description(e.message?: "Unknown Error")
            ))
        }
    }.asCommonFlow()

}