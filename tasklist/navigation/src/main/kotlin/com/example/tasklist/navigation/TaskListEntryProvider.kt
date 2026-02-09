package com.example.tasklist.navigation

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.example.core.navigation.Navigator
import com.example.core.navigation.Route
import com.example.tasklist.impl.presentation.TaskListScreen


fun EntryProviderScope<NavKey>.tasklistEntryBuilder(navigator: Navigator) {
    entry<Route.TaskList> {
        TaskListScreen(
            onItemClick = { navigator.navigate(Route.TaskDetails(it)) },
            onAddTaskClick = { navigator.navigate(Route.AddTask) },
        )
    }
}
