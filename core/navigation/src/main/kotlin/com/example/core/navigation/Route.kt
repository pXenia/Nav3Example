package com.example.core.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed interface Route: NavKey {
    @Serializable
    data object TaskList: Route
    @Serializable
    data object AddTask: Route
    @Serializable
    data class TaskDetails(val id: Long): Route
    @Serializable
    data class SelectColor(val id: Long): Route
}