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

val taskListFeature = TopLevelNavigationItem(
    icon = Icons.Default.Task,
    title = "Задачи",
)

val selectColorFeature = TopLevelNavigationItem(
    icon = Icons.Default.ColorLens,
    title = "Цвета",
)

val topLevelNavItems = mapOf(
    TasksListNavKey to taskListFeature,
    SelectColorScreenNavKey to selectColorFeature
)
