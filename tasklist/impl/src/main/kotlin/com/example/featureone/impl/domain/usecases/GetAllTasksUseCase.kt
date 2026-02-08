package com.example.featureone.impl.domain.usecases

import com.example.core.models.Task
import kotlinx.coroutines.flow.Flow

interface GetAllTasksUseCase {
    operator fun invoke(): Flow<List<Task>>
}
