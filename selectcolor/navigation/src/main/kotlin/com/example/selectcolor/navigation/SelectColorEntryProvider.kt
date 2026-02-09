package com.example.selectcolor.navigation

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.example.core.navigation.Navigator
import com.example.core.navigation.Route
import com.example.featuretwo.impl.presentation.SelectColorScreen

fun EntryProviderScope<NavKey>.selectColorEntryBuilder(navigator: Navigator, topLevelRoute: NavKey) {
    entry<Route.SelectColor> { key ->
        SelectColorScreen(
            stackSize = navigator.getCurrentStackSize(),
            onBack = { navigator.goBack() },
            addNewScreen = { navigator.navigate(Route.SelectColor(key.id + 1)) },
            onResetToRoot = {
                navigator.popUpTo(
                    route = topLevelRoute,
                    inclusive = false
                )
            }
        )
    }
}
