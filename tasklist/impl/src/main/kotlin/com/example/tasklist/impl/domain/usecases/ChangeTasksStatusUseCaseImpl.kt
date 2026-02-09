package com.example.tasklist.impl.domain.usecases

import com.example.tasklist.impl.domain.TasksRepository
import jakarta.inject.Inject

class ChangeTasksStatusUseCaseImpl @Inject constructor(
    private val repository: TasksRepository
) : ChangeTasksStatusUseCase {
    override suspend fun invoke(id: Long, isCompleted: Boolean) {
        repository.changeTaskStatus(id = id, isCompleted = isCompleted)
    }
}
