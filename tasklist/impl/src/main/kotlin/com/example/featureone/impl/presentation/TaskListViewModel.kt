package com.example.featureone.impl.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.featureone.impl.domain.usecases.ChangeTasksStatusUseCase
import com.example.featureone.impl.domain.usecases.DeleteTaskUseCase
import com.example.featureone.impl.domain.usecases.GetAllTasksUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

@HiltViewModel
class TaskListViewModel @Inject constructor(
    getAllTasksUseCase: GetAllTasksUseCase,
    private val deleteTaskUseCase: DeleteTaskUseCase,
    private val changeTasksStatusUseCase: ChangeTasksStatusUseCase
) : ViewModel() {

    val state: StateFlow<TaskListScreenState> = getAllTasksUseCase()
        .map { tasks -> TaskListScreenState(tasks = tasks, isLoading = false) }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = TaskListScreenState(isLoading = true)
        )

    fun onIntent(
        intent: TaskListScreenIntent,
    ) {
        when (intent) {
            is TaskListScreenIntent.DeleteTask -> deleteTask(intent.id)
            is TaskListScreenIntent.ChangeStatus -> changeStatus(intent.id, intent.currentStatus)
        }
    }

    private fun deleteTask(id: Long) {
        viewModelScope.launch { deleteTaskUseCase(id) }
    }

    private fun changeStatus(id: Long, currentStatus: Boolean) {
        viewModelScope.launch { changeTasksStatusUseCase(id, !currentStatus) }
    }
}
