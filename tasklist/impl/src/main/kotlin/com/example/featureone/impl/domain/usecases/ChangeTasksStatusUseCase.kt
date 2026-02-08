package com.example.featureone.impl.domain.usecases

interface ChangeTasksStatusUseCase {
    suspend operator fun invoke(id: Long, isCompleted: Boolean)
}
