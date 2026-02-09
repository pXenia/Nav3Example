package com.example.taskdetails.impl.presentation.data

import com.example.core.database.dao.TaskDao
import com.example.core.database.models.TaskEntity
import com.example.core.database.models.toTask
import com.example.core.models.Task
import com.example.taskdetails.impl.presentation.domain.TaskRepository
import jakarta.inject.Inject


class TaskRepositoryImpl @Inject constructor(
    private val taskDao: TaskDao
) : TaskRepository {
    override suspend fun getTaskById(id: Long): Task? = taskDao.getTaskById(id)?.toTask()

    override suspend fun addTask(title: String) =
        taskDao.insertTask(TaskEntity(title = title, isCompleted = false))
}
