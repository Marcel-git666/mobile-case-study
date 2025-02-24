//
//  CoinRowView.swift
//  iosApp
//
//  Created by Marcel Mravec on 24.02.2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI
import shared

struct CoinRowView: View {
    let coin: Coin
    let onFavoriteClick: () -> Void

    var body: some View {
        HStack {
            VStack(alignment: .leading) {
                Text(coin.name)
                    .font(.headline)
                Text("$\(String(format: "%.2f", coin.currentPrice))")
                    .font(.subheadline)
                Text("\(String(format: "%.2f", coin.priceChangePercentage24h))%")
                    .foregroundColor(coin.priceChangePercentage24h >= 0 ? .green : .red)
            }

            Spacer()

            Button(action: onFavoriteClick) {
                Image(systemName: coin.isFavorite ? "heart.fill" : "heart")
                    .foregroundColor(coin.isFavorite ? .red : .gray)
            }
        }
        .padding(.vertical, 8)
    }
}

//#Preview {
//    CoinRowView()
//}
