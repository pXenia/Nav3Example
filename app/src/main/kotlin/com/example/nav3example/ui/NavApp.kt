package com.example.nav3example.ui

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import com.example.core.navigation.toEntries
import com.example.featuredetail.navigation.featureTaskDetailEntryBuilder
import com.example.featureone.navigation.featureOneEntryBuilder
import com.example.nav3example.navigation.topLevelNavItems
import com.example.selectcolor.navigation.selectColorEntryBuilder

/** Root экран приложения.*/
@Composable
fun NavApp(appState: AppState = rememberAppState()) {
    Scaffold(
        bottomBar = {
            if (appState.shouldShowBottomBar) {
                NavigationBar {
                    topLevelNavItems.forEach { (key, item) ->
                        val selected = key == appState.navigationState.currentTopLevelKey
                        NavigationBarItem(
                            selected = selected,
                            onClick = { appState.navigator.navigate(key) },
                            icon = { Icon(item.icon, contentDescription = null) },
                            label = { Text(item.title) }
                        )
                    }
                }
            }
        }
    ) { padding ->
        val entryProvider = entryProvider {
            featureOneEntryBuilder(appState.navigator)
            selectColorEntryBuilder()
            featureTaskDetailEntryBuilder(appState.navigator)
        }

        Box(modifier = Modifier.fillMaxSize().padding(padding)) {
            val duration = 1000
            NavDisplay(
                entries = appState.navigationState.toEntries(entryProvider),
                onBack = { appState.navigator.goBack() },
                transitionSpec = {
                    slideInHorizontally(
                        initialOffsetX = { it },
                        animationSpec = tween(duration)
                    ) togetherWith slideOutHorizontally(
                        targetOffsetX = { -it / 3 },
                        animationSpec = tween(duration)
                    ) + fadeOut(animationSpec = tween(duration))
                },
                popTransitionSpec = {
                    slideInHorizontally(
                        initialOffsetX = { -it / 3 },
                        animationSpec = tween(duration)
                    ) + fadeIn(animationSpec = tween(duration)) togetherWith slideOutHorizontally(
                        targetOffsetX = { it },
                        animationSpec = tween(duration)
                    )
                },
                predictivePopTransitionSpec = {
                    slideInHorizontally(
                        initialOffsetX = { -it / 3 },
                        animationSpec = tween(duration)
                    ) + fadeIn(animationSpec = tween(duration)) togetherWith slideOutHorizontally(
                        targetOffsetX = { it },
                        animationSpec = tween(duration)
                    )
                }
            )
        }
    }
}
