package com.example.featuredetail.impl.presentation.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.featuredetail.impl.presentation.domain.usecase.AddTaskUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class AddTaskViewModel @Inject constructor(
    private val addTaskUseCase: AddTaskUseCase
) : ViewModel() {
    private val _isSaved = MutableStateFlow(false)
    val isSaved = _isSaved.asStateFlow()

    fun save(title: String) {
        viewModelScope.launch {
            addTaskUseCase(title)
            _isSaved.value = true
        }
    }
}
