package com.example.featuredetail.impl.presentation.presentation

import com.example.core.models.Task

sealed interface TaskScreenState {
    object Loading : TaskScreenState
    data class Success(val task: Task) : TaskScreenState
    data class Error(val message: String) : TaskScreenState
}

sealed interface TaskScreenIntent {
    data class LoadTask(val id: Long) : TaskScreenIntent
}