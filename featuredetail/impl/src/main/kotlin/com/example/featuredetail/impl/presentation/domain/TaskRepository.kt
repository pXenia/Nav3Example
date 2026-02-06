package com.example.featuredetail.impl.presentation.domain

interface TaskRepository {
    suspend fun getTaskById(id: Long): Task?
    suspend fun addTask(title: String)
}
