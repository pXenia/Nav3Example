package com.example.featureone.impl.data

import com.example.core.database.dao.TaskDao
import com.example.core.models.Task
import com.example.featureone.api.domain.TasksRepository
import jakarta.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class TasksRepositoryImpl @Inject constructor(
    private val taskDao: TaskDao
) : TasksRepository {
    override fun getAllTasks(): Flow<List<Task>> {
        return taskDao.getAllTasks().map { taskEntities ->
            taskEntities.map { taskEntity ->
                Task(
                    id = taskEntity.id,
                    title = taskEntity.title,
                    isCompleted = taskEntity.isCompleted
                )
            }
        }
    }

    override suspend fun deleteTask(id: Long) {
        taskDao.deleteTask(id)
    }

    override suspend fun changeTaskStatus(id: Long, isCompleted: Boolean) {
        taskDao.completionStatus(id, isCompleted)
    }
}
