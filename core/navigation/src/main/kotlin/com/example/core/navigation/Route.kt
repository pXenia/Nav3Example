package com.example.core.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed interface Route: NavKey {
    @Serializable
    object TaskList: Route
    @Serializable
    object AddTask: Route
    @Serializable
    data class TaskDetails(val id: Long): Route
    @Serializable
    object SelectColor: Route
}