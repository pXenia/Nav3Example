package com.example.nav3example.ui

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
import com.example.featureone.impl.navigation.featureOneEntryBuilder
import com.example.featuretwo.impl.navigation.featureTwoEntryBuilder
import com.example.nav3example.navigation.TOP_LEVEL_NAV_ITEMS

/** Root экран приложения.*/
@Composable
fun NavApp(appState: AppState = rememberAppState()) {
    Scaffold(
        bottomBar = {
            if (appState.shouldShowBottomBar) {
                NavigationBar {
                    TOP_LEVEL_NAV_ITEMS.forEach { (key, item) ->
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
            featureTwoEntryBuilder(appState.navigator)
            featureTaskDetailEntryBuilder(appState.navigator)
        }

        Box(modifier = Modifier.fillMaxSize().padding(padding)) {
            NavDisplay(
                entries = appState.navigationState.toEntries(entryProvider),
                onBack = { appState.navigator.goBack() }
            )
        }
    }
}
