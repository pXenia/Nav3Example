package com.example.featureone.impl.domain.usecase

import com.example.featureone.impl.domain.TasksRepository
import jakarta.inject.Inject

internal class DeleteTaskUseCaseImp @Inject constructor(
    private val repository: TasksRepository
) : DeleteTaskUseCase {
    override suspend operator fun invoke(id: Long) = repository.deleteTask(id)
}
