package com.konradgroup.nav3demo.ui.settings

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.konradgroup.nav3demo.ui.navigation.Route

fun EntryProviderScope<NavKey>.settingsEntries(
    onSubRouteClick: (navKey: NavKey) -> Unit,
    navigateBack: () -> Unit,
) {
    entry<Route.Settings> {
        SettingsScreen(
            goToProfile = { onSubRouteClick(Route.Profile) }
        )
    }
    entry<Route.Profile> {
        ProfileScreen(
            navigateBack = navigateBack
        )
    }
}