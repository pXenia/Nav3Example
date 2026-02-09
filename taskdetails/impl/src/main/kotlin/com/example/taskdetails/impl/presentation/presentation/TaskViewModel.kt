package com.example.taskdetails.impl.presentation.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.taskdetails.impl.presentation.domain.usecase.GetTaskUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class TaskViewModel @Inject constructor(
    private val getTaskUseCase: GetTaskUseCase
) : ViewModel() {

    private val _state = MutableStateFlow<TaskScreenState>(TaskScreenState.Loading)
    val state = _state.asStateFlow()

    fun onIntent(intent: TaskScreenIntent) {
        when (intent) {
            is TaskScreenIntent.LoadTask -> getTask(intent.id)
        }
    }

    init {
        Log.d("TaskViewModel", "init {hash=${this.hashCode()}}")
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("TaskViewModel", "onCleared {hash=${this.hashCode()}}")
    }

    private fun getTask(id: Long) {
        viewModelScope.launch {
            val task = getTaskUseCase(id)
            _state.value = if (task != null) {
                TaskScreenState.Success(task)
            } else {
                TaskScreenState.Error("Задача с ID $id не найдена")
            }
        }
    }
}
