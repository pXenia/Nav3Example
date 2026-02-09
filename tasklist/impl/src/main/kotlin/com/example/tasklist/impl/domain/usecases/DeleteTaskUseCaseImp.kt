package com.example.tasklist.impl.domain.usecases

import com.example.tasklist.impl.domain.TasksRepository
import jakarta.inject.Inject

class DeleteTaskUseCaseImp @Inject constructor(
    private val repository: TasksRepository
) : DeleteTaskUseCase {
    override suspend operator fun invoke(id: Long) = repository.deleteTask(id)
}
