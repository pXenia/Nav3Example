package com.example.featureone.impl.presentation

import com.example.core.models.Task

data class TaskListScreenState(
    val tasks: List<Task> = emptyList(),
    val isLoading: Boolean = false
)

sealed interface TaskListScreenIntent {
    data class DeleteTask(val id: Long) : TaskListScreenIntent
    data class ChangeStatus(val id: Long, val currentStatus: Boolean) : TaskListScreenIntent
}