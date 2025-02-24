//
//  CoinListView.swift
//  iosApp
//
//  Created by Marcel Mravec on 24.02.2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI
import shared

struct CoinListView: View {
    private let viewModel: CoinsViewModel
    @State private var state: CoinsState = CoinsState.Loading()

    init(viewModel: CoinsViewModel) {
        self.viewModel = viewModel
    }

    var body: some View {
        NavigationView {
            Group {
                switch state {
                case is CoinsState.Loading:
                    ProgressView()

                case let success as CoinsState.Success:
                    List {
                        Section(header: Text("Trending Coins")) {
                            ForEach(success.trendingCoins, id: \.id) { coin in
                                CoinRowView(
                                    coin: coin,
                                    onFavoriteClick: { viewModel.toggleFavorite(coinId: coin.id) }
                                )
                            }
                        }

                        Section(header: Text("Favorite Coins")) {
                            ForEach(success.favoriteCoins, id: \.id) { coin in
                                CoinRowView(
                                    coin: coin,
                                    onFavoriteClick: { viewModel.toggleFavorite(coinId: coin.id) }
                                )
                            }
                        }
                    }

                case let error as CoinsState.Error:
                    Text(error.message)
                        .foregroundColor(.red)

                default:
                    EmptyView()
                }
            }
            .navigationTitle("Crypto")
        }
        .onAppear {
            // Zde budeme observovat stav z ViewModelu
        }
    }
}

//#Preview {
//    CoinListView()
//}
