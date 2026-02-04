package com.example.featuredetail.impl.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.ui.NavDisplay
import com.example.core.navigation.Navigator
import com.example.featuredetail.api.DetailNavKey
import com.example.featuredetail.impl.DetailScreen

fun EntryProviderScope<NavKey>.featureDetailEntryBuilder(navigator: Navigator) {
    val duration = 1000
    entry<DetailNavKey>(metadata = NavDisplay.transitionSpec {
        slideInHorizontally(
            initialOffsetX = { it }, animationSpec = tween(duration)
        ) togetherWith slideOutHorizontally(
            targetOffsetX = { -it / 3 }, animationSpec = tween(duration)
        ) + fadeOut(animationSpec = tween(duration))
    } + NavDisplay.popTransitionSpec {
        slideInHorizontally(
            initialOffsetX = { -it / 3 }, animationSpec = tween(duration)
        ) + fadeIn(animationSpec = tween(duration)) togetherWith slideOutHorizontally(
            targetOffsetX = { it }, animationSpec = tween(duration)
        )
    }) { key ->
        val id = key.id

        DetailScreen(
            id = id,
            onButtonBackClick = { navigator.goBack() }
        )
    }
}
