//
//  RecipeDetailViewModel.swift
//  iosApp
//
//  Created by admin on 23/03/2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI
import shared

class RecipeDetailViewModel: ObservableObject {

    // Dependencies
    private let getRecipe: GetRecipe
    
    // State
    @Published var state: RecipeDetailState = RecipeDetailState()
    
    init(
        recipeId: Int,
        getRecipe: GetRecipe
    ) {
        self.getRecipe = getRecipe
        // TODO("Get the recipe from cache")
    }
    
}
