package com.example.myapplication.interactors.recipe_list

import com.example.myapplication.datasource.network.RecipeService
import com.example.myapplication.domain.model.GenericMessageInfo
import com.example.myapplication.domain.model.Recipe
import com.example.myapplication.domain.model.UIComponentType
import com.example.myapplication.domain.util.CommonFlow
import com.example.myapplication.domain.util.DataState
import com.example.myapplication.domain.util.asCommonFlow
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SearchRecipes(
    private val recipeService: RecipeService,
//    private val recipeCache: RecipeCache,
) {
    fun execute(
        page: Int,
        query: String,
    ): CommonFlow<DataState<List<Recipe>>> = flow  {
        emit(DataState.loading())
        try{
            val recipes = recipeService.search(
                page = page,
                query = query,
            )

            // delay 500ms so we can see loading
            delay(500)

            // force error for testing
            if (query == "error") {
                throw Exception("Forcing an error... Search FAILED!")
            }

            // insert into cache
//            recipeCache.insert(recipes)

            // query the cache
//            val cacheResult = if (query.isBlank()) {
//                recipeCache.getAll(page = page)
//            } else {
//                recipeCache.search(
//                    query = query,
//                    page = page,
//                )
//            }

            // emit List<Recipe> from cache
            emit(DataState.data<List<Recipe>>(message = null, data = recipes))
        }catch (e: Exception){
            emit(DataState.error<List<Recipe>>(
                message = GenericMessageInfo.Builder()
                    .id("SearchRecipes.Error")
                    .title("Error")
                    .uiComponentType(UIComponentType.Dialog)
                    .description(e.message?: "Unknown Error")
            ))
        }
    }.asCommonFlow()
}









