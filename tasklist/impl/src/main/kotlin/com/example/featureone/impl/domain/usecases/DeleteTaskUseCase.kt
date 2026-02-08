package com.example.featureone.impl.domain.usecases

interface DeleteTaskUseCase {
    suspend operator fun invoke(id: Long)
}
