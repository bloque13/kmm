//
//  RecipeListScreen.swift
//  iosApp
//
//  Created by admin on 22/03/2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI
import shared

struct RecipeListScreen: View {
    
    private let networkModule: NetworkModule
    private let searchRecipesModule: SearchRecipesModule
    private let foodCategories: [FoodCategory]
    
    @ObservedObject var viewModel: RecipeListViewModel
    
    init(
        networkModule: NetworkModule
    ) {
        self.networkModule = networkModule
        self.searchRecipesModule = SearchRecipesModule(
            networkModule: self.networkModule
        )
        let foodCategoryUtil = FoodCategoryUtil()
        
        self.viewModel = RecipeListViewModel(
            searchRecipes: searchRecipesModule.searchRecipes,
            foodCategoryUtil: foodCategoryUtil
        )
        self.foodCategories = foodCategoryUtil.getAllFoodCategories()
        
    }
    
    var body: some View {
            NavigationView{
                ZStack{
                    VStack{
                        SearchAppBar(
                            query: viewModel.state.query,
                            selectedCategory: viewModel.state.selectedCategory,
                            foodCategories: foodCategories,
                            onTriggerEvent: { event in
                                viewModel.onTriggerEvent(stateEvent: event)
                            }
                        )
                        List {
                            ForEach(viewModel.state.recipes, id: \.self.id){ recipe in
                                ZStack{
                                    VStack{
                                        RecipeCard(recipe: recipe)
                                            .onAppear(perform: {
                                                if viewModel.shouldQueryNextPage(recipe: recipe){
                                                    viewModel.onTriggerEvent(stateEvent: RecipeListEvents.NextPage())
                                                }
                                            })
                                    }
                                    NavigationLink(
                                        destination: RecipeDetailScreen(
                                            recipeId: Int(recipe.id)
                                        )
                                    ){
                                        // workaround for hiding arrows
                                        EmptyView()
                                    }.hidden().frame(width: 0)
                                }
                                .listRowInsets(EdgeInsets())
                                .padding(.top, 10)
                            }
                        }
                        .listStyle(PlainListStyle())
                        .background(Color.gray)
                    }
                    if viewModel.state.isLoading {
                        ProgressView("Searching recipes...")
                    }
                }
                .navigationBarHidden(true)
            }
        }
    
}

//struct RecipeListScreen_Previews: PreviewProvider {
//    static var previews: some View {
//        RecipeListScreen()
//    }
//}
