package com.example.featureone.navigation

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.example.core.navigation.Navigator
import com.example.featuredetail.navigation.CreateTaskNavKey
import com.example.featuredetail.navigation.navigateToTaskDetail
import com.example.featureone.impl.presentation.TaskListScreen

fun EntryProviderScope<NavKey>.featureOneEntryBuilder(navigator: Navigator) {
    entry<TasksListNavKey> {
        TaskListScreen(
            onItemClick = navigator::navigateToTaskDetail,
            onAddTaskClick = {navigator.navigate(CreateTaskNavKey)},
        )
    }
}
