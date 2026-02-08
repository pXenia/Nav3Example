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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun AddTaskScreen(
    onBack: () -> Unit,
    viewModel: AddTaskViewModel = hiltViewModel()
) {
    var taskTitle by remember { mutableStateOf("") }
    val isSaved by viewModel.isSaved.collectAsState()

    LaunchedEffect(isSaved) {
        if (isSaved) {
            onBack()
        }
    }

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
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            OutlinedTextField(
                value = taskTitle,
                onValueChange = { taskTitle = it },
                label = { Text("Введите текст задачи") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

            Button(
                onClick = { viewModel.save(taskTitle) },
                modifier = Modifier.fillMaxWidth(),
                enabled = taskTitle.isNotBlank()
            ) {
                Text(text = "Сохранить")
            }

            TextButton(onClick = onBack) {
                Text(text = "Отмена")
            }
        }
    }
}
