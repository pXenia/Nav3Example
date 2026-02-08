package com.example.featuredetail.impl.presentation.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.models.Task
import com.example.featuredetail.impl.presentation.domain.usecase.GetTaskUseCase
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@HiltViewModel(assistedFactory = TaskViewModel.Factory::class)
class TaskViewModel @AssistedInject constructor(
    @Assisted val id: Long,
    private val getTaskUseCase: GetTaskUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<TaskUiState>(TaskUiState.Loading)
    val uiState = _uiState.asStateFlow()

    init {
        getTask()
    }

    private fun getTask() {
        viewModelScope.launch {
            val task = getTaskUseCase(id)
            _uiState.value = if (task != null) {
                TaskUiState.Success(task)
            } else {
                TaskUiState.Error("Задача с ID $id не найдена")
            }
        }
    }

    @AssistedFactory
    interface Factory {
        fun create(id: Long): TaskViewModel
    }
}

sealed interface TaskUiState {
    object Loading : TaskUiState
    data class Success(val task: Task) : TaskUiState
    data class Error(val message: String) : TaskUiState
}
