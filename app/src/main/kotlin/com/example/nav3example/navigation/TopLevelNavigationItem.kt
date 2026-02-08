package com.example.nav3example.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ColorLens
import androidx.compose.material.icons.filled.Task
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.featureone.navigation.keys.TasksListNavKey
import com.example.selectcolor.navigation.keys.SelectColorScreenNavKey

/**
 * Элементы навигации верхнего уровня.
 * Элементы пользовательского интерфейса для Bottom Navigation.
 */
data class TopLevelNavigationItem(
    val icon: ImageVector,
    val title: String
)

val FEATURE_ONE = TopLevelNavigationItem(
    icon = Icons.Default.Task,
    title = "Задачи",
)

val FEATURE_TWO = TopLevelNavigationItem(
    icon = Icons.Default.ColorLens,
    title = "Цвета",
)

val TOP_LEVEL_NAV_ITEMS = mapOf(
    TasksListNavKey to FEATURE_ONE,
    SelectColorScreenNavKey to FEATURE_TWO
)
