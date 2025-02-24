import SwiftUI
import shared

@main
struct iOSApp: App {
    init() {
        // Inicializace Koin při startu aplikace
        KoinModuleKt.doInitKoin()
    }

	var body: some Scene {
		WindowGroup {
            CoinListView(viewModel: KoinHelper().getViewModel())
		}
	}
}
