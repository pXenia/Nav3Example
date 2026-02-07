package com.example.featureone.api.domain

interface DeleteTaskUseCase {
    suspend operator fun invoke(id: Long)
}
