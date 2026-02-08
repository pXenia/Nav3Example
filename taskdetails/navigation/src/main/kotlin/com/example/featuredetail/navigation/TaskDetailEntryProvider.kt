package com.example.featuredetail.navigation

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.example.core.navigation.Navigator
import com.example.featuredetail.impl.presentation.presentation.AddTaskScreen
import com.example.featuredetail.impl.presentation.presentation.TaskScreen
import com.example.featuredetail.navigation.keys.CreateTaskNavKey
import com.example.featuredetail.navigation.keys.TaskDetailNavKey

fun EntryProviderScope<NavKey>.featureTaskDetailEntryBuilder(navigator: Navigator) {
    entry<TaskDetailNavKey> { key ->
        TaskScreen(
            id = key.id,
            onButtonBackClick = { navigator.goBack() },
        )
    }

    entry<CreateTaskNavKey> {
        AddTaskScreen(
            onBack = { navigator.goBack() },
        )
    }
}
