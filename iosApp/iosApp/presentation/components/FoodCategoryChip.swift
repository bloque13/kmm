//
//  FoodCategoryChip.swift
//  iosApp
//
//  Created by admin on 23/03/2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI

struct FoodCategoryChip: View {
    
    private let category: String
    private let isSelected: Bool
    
    init(category: String, isSelected: Bool = false) {
        self.category = category
        self.isSelected = isSelected
    }
    var body: some View {
        HStack{
            Text(category) // TODO("update font")
                .padding(8)
                .background(isSelected ? Color.gray : Color.blue) // TODO("update gray color")
                .foregroundColor(Color.white)
        }
        .cornerRadius(10)
    }
}

//struct FoodCategoryChip_Previews: PreviewProvider {
//    static var previews: some View {
//        FoodCategoryChip(category: "Chicken")
//    }
//}
