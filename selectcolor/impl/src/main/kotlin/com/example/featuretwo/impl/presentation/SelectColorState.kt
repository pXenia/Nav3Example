package com.example.featuretwo.impl.presentation

import androidx.compose.ui.graphics.Color

data class SelectColorScreenState(
    val backGroundColor: Color = Color.White, val isSelectColorDialogVisible: Boolean = false
)

sealed interface SelectColorScreenIntent {
    data object ShowDialog : SelectColorScreenIntent
    data object HideDialog : SelectColorScreenIntent
    data class ApplyColor(val red: Int, val green: Int, val blue: Int) : SelectColorScreenIntent
}