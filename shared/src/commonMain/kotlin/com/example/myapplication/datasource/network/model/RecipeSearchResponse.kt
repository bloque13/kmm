package com.example.myapplication.datasource.network.model

import com.example.myapplication.datasource.network.model.RecipeDto
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RecipeSearchResponse(

    @SerialName("count")
        var count: Int,

    @SerialName("results")
        var results: List<RecipeDto>,
)