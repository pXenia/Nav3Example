package com.example.featuredetail.impl.presentation.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun TaskScreen(
    id: Long,
    onButtonBackClick: () -> Unit,
    viewModel: TaskViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()

    LaunchedEffect(id) {
        viewModel.onIntent(TaskScreenIntent.LoadTask(id))
    }

    TaskScreenContent(
        state = state,
        onButtonBackClick = onButtonBackClick
    )
}

@Composable
private fun TaskScreenContent(
    state: TaskScreenState,
    onButtonBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        when (state) {
            is TaskScreenState.Loading -> CircularProgressIndicator()
            is TaskScreenState.Error -> Text(state.message, color = Color.Red)
            is TaskScreenState.Success -> {
                val task = state.task
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "ID: ${task.id}",
                        style = MaterialTheme.typography.labelSmall
                    )
                    Text(
                        text = task.title,
                        style = MaterialTheme.typography.headlineMedium
                    )
                    Button(onClick = onButtonBackClick) { Text("Назад") }
                }
            }
        }
    }
}
