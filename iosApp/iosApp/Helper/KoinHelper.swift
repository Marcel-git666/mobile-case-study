//
//  KoinHelper.swift
//  iosApp
//
//  Created by Marcel Mravec on 24.02.2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import shared

class KoinHelper {
    func getViewModel() -> CoinsViewModel {
        let appModule = KoinModuleKt.appModule()
        // Pro Koin 4.x
        let viewModel = appModule.getViewModel() as! CoinsViewModel
        return viewModel
    }
}
