package com.example.featureone.navigation

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.example.core.navigation.Navigator
import com.example.featuredetail.navigation.keys.CreateTaskNavKey
import com.example.featuredetail.navigation.keys.navigateToTaskDetail
import com.example.featureone.impl.presentation.TaskListScreen
import com.example.featureone.navigation.keys.TasksListNavKey

fun EntryProviderScope<NavKey>.featureOneEntryBuilder(navigator: Navigator) {
    entry<TasksListNavKey> {
        TaskListScreen(
            onItemClick = navigator::navigateToTaskDetail,
            onAddTaskClick = {navigator.navigate(CreateTaskNavKey)},
        )
    }
}
