package com.example.taskdetails.impl.presentation.domain.usecase

import com.example.taskdetails.impl.presentation.domain.TaskRepository
import jakarta.inject.Inject

class AddTaskUseCase @Inject constructor(
    private val repository: TaskRepository
) {
    suspend operator fun invoke(title: String) {
        if (title.isBlank()) return
        repository.addTask(title)
    }
}
