package com.example.featuredetail.impl.presentation.domain.usecase

import com.example.core.models.Task
import com.example.featuredetail.impl.presentation.domain.TaskRepository
import jakarta.inject.Inject

class GetTaskUseCase @Inject constructor(
    private val repository: TaskRepository
) {
    suspend operator fun invoke(id: Long): Task? = repository.getTaskById(id)
}
