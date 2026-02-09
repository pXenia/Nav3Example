package com.example.taskdetails.navigation

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.example.core.navigation.Navigator
import com.example.core.navigation.Route
import com.example.taskdetails.impl.presentation.presentation.AddTaskScreen
import com.example.taskdetails.impl.presentation.presentation.TaskScreen


fun EntryProviderScope<NavKey>.taskDetailEntryBuilder(navigator: Navigator) {
    entry<Route.TaskDetails> { key ->
        TaskScreen(
            id = key.id,
            onButtonBackClick = { navigator.goBack() },
        )
    }

    entry<Route.AddTask> {
        AddTaskScreen(
            onBack = { navigator.goBack() },
        )
    }
}
