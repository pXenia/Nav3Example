package com.example.featuredetail.impl.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@HiltViewModel
class DetailScreenViewModel @Inject constructor() : ViewModel() {
    private val _uiState = MutableStateFlow<String?>(null)
    val uiState: StateFlow<String?> = _uiState

    private var currentId: String? = null

    fun initialize(id: String) {
        if (currentId != null) return

        currentId = id
        _uiState.value = "Для ID: $id"
        Log.d("DetailScreenViewModel", "init for ID: $id (hash: ${hashCode()})")
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("DetailScreenViewModel", "onCleared for ID: $currentId (hash: ${hashCode()})")
    }
}
