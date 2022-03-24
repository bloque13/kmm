package com.example.myapplication.android.presentation.navigation

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.myapplication.android.presentation.recipe_detail.RecipeDetailScreen
import com.example.myapplication.android.presentation.recipe_detail.RecipeDetailViewModel
import com.example.myapplication.android.presentation.recipe_list.RecipeListScreen
import com.example.myapplication.android.presentation.recipe_list.RecipeListViewModel
import dagger.hilt.android.internal.lifecycle.HiltViewModelFactory

@ExperimentalComposeUiApi
@ExperimentalMaterialApi
@ExperimentalStdlibApi
@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.RecipeList.route) {
        composable(route = Screen.RecipeList.route) { navBackStackEntry ->

            // in the future, the hilt-navigation-compose artifact will simplify this

            val viewModel: RecipeListViewModel = hiltViewModel<RecipeListViewModel>()
            RecipeListScreen(
                state = viewModel.state.value,
                onTriggerEvent = viewModel::onTriggerEvent,
                viewModel = viewModel,
                onSelectRecipe = { recipeId ->
                    navController.navigate("${Screen.RecipeDetail.route}/$recipeId")
                }
            )
        }
        composable(
            route = Screen.RecipeDetail.route + "/{recipeId}",
            arguments = listOf(navArgument("recipeId") {
                type = NavType.IntType
            })
        ) { navBackStackEntry ->
            val viewModel: RecipeDetailViewModel = hiltViewModel<RecipeDetailViewModel>()
            RecipeDetailScreen(
                state = viewModel.state.value,
                onTriggerEvent = viewModel::onTriggerEvent
            )
        }
    }
}
