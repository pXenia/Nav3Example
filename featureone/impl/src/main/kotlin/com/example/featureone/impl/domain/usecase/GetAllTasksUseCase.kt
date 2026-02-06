package com.example.featureone.impl.domain.usecase

import com.example.featureone.impl.domain.Task
import kotlinx.coroutines.flow.Flow

interface GetAllTasksUseCase {
    operator fun invoke(): Flow<List<Task>>
}
