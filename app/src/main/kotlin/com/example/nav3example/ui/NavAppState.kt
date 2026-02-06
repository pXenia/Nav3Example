package com.example.nav3example.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.navigation3.runtime.NavKey
import com.example.core.navigation.NavigationState
import com.example.core.navigation.Navigator
import com.example.core.navigation.rememberNavigationState
import com.example.featureone.api.TasksListNavKey
import com.example.featuretwo.api.FeatureTwoNavKey

/**
 * Обеспечивая сохранение состояния навигации при перекомпоновке.
 *
 * @param startKey Начальный экран приложения.
 * @param topLevelKeys Набор ключей для разделов нижнего меню.
 */
@Composable
fun rememberAppState(
    startKey: NavKey = TasksListNavKey,
    topLevelKeys: Set<NavKey> = setOf(TasksListNavKey, FeatureTwoNavKey)
): AppState {
    val navigationState = rememberNavigationState(
        startKey = startKey,
        topLevelKeys = topLevelKeys
    )

    return remember(navigationState) {
        AppState(navigationState)
    }
}

/**
 * Состояние приложения.
 *
 * @property navigationState Текущее состояние графа навигации.
 */
@Stable
class AppState(
    val navigationState: NavigationState,
) {
    val navigator = Navigator(navigationState)

    // Скрытие нижней навигационной панели
    val shouldShowBottomBar: Boolean
        get() = navigationState.currentSubStack.size == 1

    val currentKey: NavKey
        get() = navigationState.currentKey
}
