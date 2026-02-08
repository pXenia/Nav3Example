package com.example.featuredetail.impl.presentation.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.featuredetail.impl.presentation.domain.usecase.AddTaskUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
class AddTaskViewModel @Inject constructor(
    private val addTaskUseCase: AddTaskUseCase
) : ViewModel() {
    private val _state = MutableStateFlow(AddTaskScreenState())
    val state = _state.asStateFlow()

    fun onIntent(intent: AddTaskScreenIntent) {
        when (intent) {
            is AddTaskScreenIntent.TitleChanged -> {
                _state.update { it.copy(title = intent.newTitle) }
            }
            is AddTaskScreenIntent.SaveClicked -> {
                save()
            }
        }
    }

    private fun save() {
        val currentTitle = _state.value.title
        if (currentTitle.isBlank()) return

        viewModelScope.launch {
            addTaskUseCase(currentTitle)
            _state.update { it.copy(isSaved = true) }
        }
    }
}
