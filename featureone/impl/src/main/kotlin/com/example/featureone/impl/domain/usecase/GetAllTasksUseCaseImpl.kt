package com.example.featureone.impl.domain.usecase

import com.example.featureone.impl.domain.TasksRepository
import jakarta.inject.Inject

internal class GetAllTasksUseCaseImpl @Inject constructor(
    private val repository: TasksRepository
) : GetAllTasksUseCase {
    override operator fun invoke() = repository.getAllTasks()
}
