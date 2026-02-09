package com.example.tasklist.impl.data

import com.example.core.database.dao.TaskDao
import com.example.core.database.models.toTask
import com.example.core.models.Task
import com.example.tasklist.impl.domain.TasksRepository
import jakarta.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class TasksRepositoryImpl @Inject constructor(
    private val taskDao: TaskDao
) : TasksRepository {
    override fun getAllTasks(): Flow<List<Task>> {
        return taskDao.getAllTasks().map { taskEntities ->
            taskEntities.map { it.toTask() }
        }
    }

    override suspend fun deleteTask(id: Long) {
        taskDao.deleteTask(id)
    }

    override suspend fun changeTaskStatus(id: Long, isCompleted: Boolean) {
        taskDao.completionStatus(id, isCompleted)
    }
}
