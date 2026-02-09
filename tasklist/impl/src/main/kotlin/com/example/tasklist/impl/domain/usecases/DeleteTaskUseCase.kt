package com.example.tasklist.impl.domain.usecases

interface DeleteTaskUseCase {
    suspend operator fun invoke(id: Long)
}
