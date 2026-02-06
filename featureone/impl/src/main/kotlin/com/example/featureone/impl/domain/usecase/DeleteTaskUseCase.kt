package com.example.featureone.impl.domain.usecase

interface DeleteTaskUseCase {
    suspend operator fun invoke(id: Long)
}
