package com.example.featuretwo.impl.presentation

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

@HiltViewModel
class SelectColorViewModel @Inject constructor() : ViewModel() {
    private val _state = MutableStateFlow(SelectColorScreenState())
    val state: StateFlow<SelectColorScreenState> = _state.asStateFlow()

    fun onIntent(intent: SelectColorScreenIntent){
        when(intent){
            is SelectColorScreenIntent.ApplyColor -> applyColors(intent.red, intent.green, intent.blue)
            is SelectColorScreenIntent.HideDialog -> _state.update { it.copy(isSelectColorDialogVisible = false) }
            is SelectColorScreenIntent.ShowDialog -> _state.update { it.copy(isSelectColorDialogVisible = true) }
        }
    }

    private fun applyColors(red: Int, green: Int, blue: Int) {
        val r = red.coerceIn(0, 255)
        val g = green.coerceIn(0, 255)
        val b = blue.coerceIn(0, 255)

        val color = Color(r, g, b)

        _state.update {
            it.copy(
                isSelectColorDialogVisible = false,
                backGroundColor = color
            )
        }
    }
}
