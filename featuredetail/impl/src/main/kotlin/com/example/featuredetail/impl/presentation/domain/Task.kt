package com.example.featuredetail.impl.presentation.domain

data class Task(
    val id: Long = 0,
    val title: String,
    val isCompleted: Boolean = false
)
