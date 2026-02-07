package com.example.featureone.api.domain

interface ChangeTasksStatusUseCase {
    suspend operator fun invoke(id: Long, isCompleted: Boolean)
}
