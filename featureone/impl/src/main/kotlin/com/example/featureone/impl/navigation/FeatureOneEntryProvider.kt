package com.example.featureone.impl.navigation

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.example.core.navigation.Navigator
import com.example.featuredetail.navigation.CreateTaskNavKey
import com.example.featuredetail.navigation.navigateToTaskDetail
import com.example.featureone.api.TasksListNavKey
import com.example.featureone.impl.presentation.TaskListScreen

/** Регистрирует сопоставление ключа с соответствующим экраном.*/
fun EntryProviderScope<NavKey>.featureOneEntryBuilder(navigator: Navigator) {
    entry<TasksListNavKey> {
        TaskListScreen(
            onItemClick = navigator::navigateToTaskDetail,
            onAddTaskClick = {navigator.navigate(CreateTaskNavKey)},
        )
    }
}
