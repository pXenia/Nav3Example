package com.example.tasklist.impl.domain.usecases

interface ChangeTasksStatusUseCase {
    suspend operator fun invoke(id: Long, isCompleted: Boolean)
}
