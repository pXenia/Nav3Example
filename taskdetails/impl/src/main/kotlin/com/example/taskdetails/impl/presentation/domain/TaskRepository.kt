package com.example.taskdetails.impl.presentation.domain

import com.example.core.models.Task

interface TaskRepository {
    suspend fun getTaskById(id: Long): Task?
    suspend fun addTask(title: String)
}
