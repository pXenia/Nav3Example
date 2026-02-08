package com.example.featureone.impl.domain.usecases

import com.example.featureone.impl.domain.TasksRepository
import jakarta.inject.Inject

class GetAllTasksUseCaseImpl @Inject constructor(
    private val repository: TasksRepository
) : GetAllTasksUseCase {
    override operator fun invoke() = repository.getAllTasks()
}
