package com.example.nav3example.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ColorLens
import androidx.compose.material.icons.filled.Task
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.core.navigation.Route

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

val addTaskFeature = TopLevelNavigationItem(
    icon = Icons.Default.Add,
    title = "Добавить",
)

val topLevelNavItems = mapOf(
    Route.TaskList to taskListFeature,
    Route.SelectColor(1) to selectColorFeature,
    Route.AddTask to addTaskFeature
)
