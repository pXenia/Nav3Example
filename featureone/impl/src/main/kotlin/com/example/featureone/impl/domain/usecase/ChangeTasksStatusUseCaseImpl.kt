package com.example.featureone.impl.domain.usecase

import com.example.featureone.impl.domain.TasksRepository
import jakarta.inject.Inject

internal class ChangeTasksStatusUseCaseImpl @Inject constructor(
    private val repository: TasksRepository
) : ChangeTasksStatusUseCase {
    override suspend fun invoke(id: Long, isCompleted: Boolean) {
        repository.changeTaskStatus(id = id, isCompleted = isCompleted)
    }
}
