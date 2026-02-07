package com.example.featureone.impl.domain

import com.example.featureone.api.domain.DeleteTaskUseCase
import com.example.featureone.api.domain.TasksRepository
import jakarta.inject.Inject

class DeleteTaskUseCaseImp @Inject constructor(
    private val repository: TasksRepository
) : DeleteTaskUseCase {
    override suspend operator fun invoke(id: Long) = repository.deleteTask(id)
}
