package com.example.featureone.impl.domain

import com.example.featureone.api.domain.ChangeTasksStatusUseCase
import com.example.featureone.api.domain.TasksRepository
import jakarta.inject.Inject

class ChangeTasksStatusUseCaseImpl @Inject constructor(
    private val repository: TasksRepository
) : ChangeTasksStatusUseCase {
    override suspend fun invoke(id: Long, isCompleted: Boolean) {
        repository.changeTaskStatus(id = id, isCompleted = isCompleted)
    }
}
