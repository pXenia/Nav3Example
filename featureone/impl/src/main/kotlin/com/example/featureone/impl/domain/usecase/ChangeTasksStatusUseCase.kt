package com.example.featureone.impl.domain.usecase

interface ChangeTasksStatusUseCase {
    suspend operator fun invoke(id: Long, isCompleted: Boolean)
}
