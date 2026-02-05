package com.example.featureone.impl.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject

@HiltViewModel
class FeatureOneViewModel @Inject constructor() : ViewModel() {
    init {
        Log.d("FeatureOneViewModel", "init FEATURE ONE")
    }

    override fun onCleared() {
        super.onCleared()

        Log.d("FeatureOneViewModel", "onCleared FEATURE ONE")
    }
}
