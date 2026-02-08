package com.example.featuredetail.impl.presentation.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun AddTaskScreen(
    onBack: () -> Unit,
    viewModel: AddTaskViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()

    LaunchedEffect(state.isSaved) {
        if (state.isSaved) {
            onBack()
        }
    }

    AddTaskScreenContent(
        state = state,
        onBack = onBack,
        onIntent = viewModel::onIntent
    )
}

@Composable
private fun AddTaskScreenContent(
    state: AddTaskScreenState,
    onBack: () -> Unit,
    onIntent: (AddTaskScreenIntent) -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            Text(
                text = "Новая задача",
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.headlineMedium
            )
        }
    ) { paddingValues ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            OutlinedTextField(
                value = state.title,
                onValueChange = { onIntent(AddTaskScreenIntent.TitleChanged(it)) },
                label = { Text("Введите текст задачи") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

            Button(
                onClick = { onIntent(AddTaskScreenIntent.SaveClicked) },
                modifier = Modifier.fillMaxWidth(),
                enabled = state.title.isNotBlank()
            ) {
                Text(text = "Сохранить")
            }

            TextButton(onClick = onBack) {
                Text(text = "Отмена")
            }
        }
    }
}
