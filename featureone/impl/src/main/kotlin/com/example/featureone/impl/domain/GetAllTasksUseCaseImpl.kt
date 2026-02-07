package com.example.featureone.impl.domain

import com.example.featureone.api.domain.GetAllTasksUseCase
import com.example.featureone.api.domain.TasksRepository
import jakarta.inject.Inject

class GetAllTasksUseCaseImpl @Inject constructor(
    private val repository: TasksRepository
) : GetAllTasksUseCase {
    override operator fun invoke() = repository.getAllTasks()
}
