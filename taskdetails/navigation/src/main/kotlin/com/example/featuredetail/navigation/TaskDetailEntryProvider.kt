package com.example.featuredetail.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.ui.NavDisplay
import com.example.core.navigation.Navigator
import com.example.featuredetail.impl.presentation.presentation.AddTaskScreen
import com.example.featuredetail.impl.presentation.presentation.TaskScreen
import com.example.featuredetail.impl.presentation.presentation.TaskViewModel
import com.example.featuredetail.navigation.keys.CreateTaskNavKey
import com.example.featuredetail.navigation.keys.TaskDetailNavKey

fun EntryProviderScope<NavKey>.featureTaskDetailEntryBuilder(navigator: Navigator) {
    val duration = 1000
    entry<TaskDetailNavKey>(metadata = NavDisplay.transitionSpec {
        slideInHorizontally(
            initialOffsetX = { it }, animationSpec = tween(duration)
        ) togetherWith slideOutHorizontally(
            targetOffsetX = { -it / 3 }, animationSpec = tween(duration)
        ) + fadeOut(animationSpec = tween(duration))
    } + NavDisplay.popTransitionSpec {
        slideInHorizontally(
            initialOffsetX = { -it / 3 }, animationSpec = tween(duration)
        ) + fadeIn(animationSpec = tween(duration)) togetherWith slideOutHorizontally(
            targetOffsetX = { it }, animationSpec = tween(duration)
        )
    }) { key ->
        val id = key.id

        TaskScreen(
            onButtonBackClick = { navigator.goBack() },
            viewModel = hiltViewModel<TaskViewModel, TaskViewModel.Factory>(
                key = id.toString()
            ) { factory ->
                factory.create(id)
            }
        )
    }
    entry<CreateTaskNavKey>{
        AddTaskScreen(
            onBack = { navigator.goBack() },
        )
    }
}
