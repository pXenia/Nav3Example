package com.example.taskdetails.impl.presentation.presentation

data class AddTaskScreenState(
    val title: String = "",
    val isSaved: Boolean = false,
)

sealed interface AddTaskScreenIntent {
    data class TitleChanged(val newTitle: String) : AddTaskScreenIntent
    data object SaveClicked : AddTaskScreenIntent
}
