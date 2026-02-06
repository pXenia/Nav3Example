package com.example.featureone.impl.domain

data class Task(
    val id: Long = 0,
    val title: String,
    val isCompleted: Boolean = false
)
