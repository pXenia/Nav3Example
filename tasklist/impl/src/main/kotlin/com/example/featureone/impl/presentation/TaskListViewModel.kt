package com.example.featureone.impl.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.models.Task
import com.example.featureone.impl.domain.usecases.ChangeTasksStatusUseCase
import com.example.featureone.impl.domain.usecases.DeleteTaskUseCase
import com.example.featureone.impl.domain.usecases.GetAllTasksUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

@HiltViewModel
class TaskListViewModel @Inject constructor(
    getAllTasksUseCase: GetAllTasksUseCase,
    private val deleteTaskUseCase: DeleteTaskUseCase,
    private val changeTasksStatusUseCase: ChangeTasksStatusUseCase
) : ViewModel() {

    val uiState: StateFlow<List<Task>> = getAllTasksUseCase()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    fun onDeleteTask(id: Long) {
        viewModelScope.launch {
            deleteTaskUseCase(id)
        }
    }

    fun changeTaskStatus(id: Long, currentStatus: Boolean) {
        viewModelScope.launch {
            changeTasksStatusUseCase(id, !currentStatus)
        }
    }
}
