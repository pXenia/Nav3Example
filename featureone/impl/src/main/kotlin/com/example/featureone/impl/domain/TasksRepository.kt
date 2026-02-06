package com.example.featureone.impl.domain

import kotlinx.coroutines.flow.Flow

internal interface TasksRepository {
    fun getAllTasks(): Flow<List<Task>>
    suspend fun deleteTask(id: Long)
    suspend fun changeTaskStatus(id: Long, isCompleted: Boolean)
}
