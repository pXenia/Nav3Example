package com.example.core.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ColorLens
import androidx.compose.material.icons.filled.Task
import androidx.compose.ui.graphics.vector.ImageVector

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
    Route.TaskList to taskListFeature,
    Route.SelectColor to selectColorFeature
)
