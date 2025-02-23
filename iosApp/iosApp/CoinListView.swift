//
//  CoinListView.swift
//  iosApp
//
//  Created by Marcel Mravec on 22.02.2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI
import shared

struct CoinListView: View {
    var body: some View {
        NavigationView {
            VStack {
                List {
                    Section(header: Text("Trending Coins")) {
                        // Zde budou trending coins
                    }

                    Section(header: Text("Favorite Coins")) {
                        // Zde budou oblíbené coins
                    }
                }
            }
            .navigationTitle("Crypto")
        }
    }
}

#Preview {
    CoinListView()
}
