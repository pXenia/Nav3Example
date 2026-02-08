package com.example.core.database.models

import com.example.core.models.Task

fun TaskEntity.toTask() = Task(
    id = id,
    title = title,
    isCompleted = isCompleted
)
