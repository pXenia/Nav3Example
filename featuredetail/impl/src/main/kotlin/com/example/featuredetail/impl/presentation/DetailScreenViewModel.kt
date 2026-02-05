package com.example.featuredetail.impl.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow

@HiltViewModel(assistedFactory = DetailScreenViewModel.Factory::class)
class DetailScreenViewModel @AssistedInject constructor(
    @Assisted val id: String
) : ViewModel() {
    val uiState = MutableStateFlow("Для ID: $id")

    init {
        Log.d("DetailScreenViewModel", "init for ID: $id")
    }

    override fun onCleared() {
        super.onCleared()

        Log.d("DetailScreenViewModel", "onCleared for ID: $id")
    }

    @AssistedFactory
    interface Factory {
        fun create(id: String): DetailScreenViewModel
    }
}
