package com.konradgroup.nav3demo.ui.navigation

import androidx.navigation3.runtime.NavKey

/**
 * A helper class that provides a high-level API for performing navigation actions.
 *
 * It wraps the [NavigationState] to simplify common navigation tasks, such as
 * switching between top-level destinations and pushing sub-screens onto the
 * active back stack.
 *
 * @property state The [NavigationState] instance that this navigator operates on.
 */
class Navigator(val state: NavigationState) {

    /**
     * Navigates to the specified [route].
     *
     * If the [route] is a registered top-level destination (one of the tabs), 
     * it switches the current [NavigationState.topLevelRoute] to that route.
     *
     * If the [route] is a sub-destination, it adds it to the back stack associated 
     * with the currently active top-level route.
     *
     * @param route The target destination to navigate to.
     */
    fun navigate(route: NavKey) {
        if (route in state.backStacks.keys) {
            // Switch to a different top-level tab
            state.topLevelRoute = route
        } else {
            // Add a sub-screen to the current tab's back stack
            // Note: Fixed to use state.topLevelRoute as the key for the map
            state.backStacks[state.topLevelRoute]?.add(route)
        }
    }

    /**
     * Performs a back navigation action.
     *
     * The behavior follows these rules:
     * 1. If the current screen is a sub-destination (not the root of the tab), 
     *    it pops it from the current stack.
     * 2. If the current screen is the root of a tab that is NOT the [NavigationState.startRoute],
     *    it switches the active tab back to the [NavigationState.startRoute].
     * 3. If it's already at the root of the start route, it does nothing.
     *
     * @throws IllegalStateException If the back stack for the current top-level route is missing.
     */
    fun goBack() {
        val currentBackStack = state.backStacks[state.topLevelRoute]
            ?: error("Back stack for ${state.topLevelRoute} doesn't exist")
        val currentRoute = currentBackStack.last()

        if (currentRoute == state.topLevelRoute) {
            // We are at the root of a tab, switch back to the main/start tab
            state.topLevelRoute = state.startRoute
        } else {
            // Pop the last screen from the current tab's stack
            currentBackStack.removeLastOrNull()
        }
    }
}
