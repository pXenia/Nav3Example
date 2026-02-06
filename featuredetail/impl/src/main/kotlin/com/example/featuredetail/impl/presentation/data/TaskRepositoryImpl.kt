package com.example.featuredetail.impl.presentation.data

import com.example.core.database.dao.TaskDao
import com.example.core.database.models.TaskEntity
import com.example.featuredetail.impl.presentation.domain.Task
import com.example.featuredetail.impl.presentation.domain.TaskRepository
import jakarta.inject.Inject


class TaskRepositoryImpl @Inject constructor(
    private val taskDao: TaskDao
) : TaskRepository {
    override suspend fun getTaskById(id: Long): Task? =
        taskDao.getTaskById(id)?.let { Task(it.id, it.title, it.isCompleted) }

    override suspend fun addTask(title: String) {
        taskDao.insertTask(TaskEntity(title = title, isCompleted = false))
    }
}
