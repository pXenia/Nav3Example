package com.example.featureone.impl.domain

import com.example.core.models.Task
import kotlinx.coroutines.flow.Flow

interface TasksRepository {
    fun getAllTasks(): Flow<List<Task>>
    suspend fun deleteTask(id: Long)
    suspend fun changeTaskStatus(id: Long, isCompleted: Boolean)
}