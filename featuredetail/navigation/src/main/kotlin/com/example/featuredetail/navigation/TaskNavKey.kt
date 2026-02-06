package com.example.featuredetail.navigation

import androidx.navigation3.runtime.NavKey
import com.example.core.navigation.Navigator
import kotlinx.serialization.Serializable

@Serializable
data class TaskDetailNavKey(val id: Long) : NavKey

@Serializable
object CreateTaskNavKey: NavKey

fun Navigator.navigateToTaskDetail(id: Long) {
    navigate(TaskDetailNavKey(id))
}
