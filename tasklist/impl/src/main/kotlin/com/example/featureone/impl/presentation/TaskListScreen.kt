package com.example.featureone.impl.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun TaskListScreen(
    onItemClick: (Long) -> Unit,
    onAddTaskClick: () -> Unit,
    viewModel: TaskListViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()

    TaskListScreenContent(
        state = state,
        onItemClick = onItemClick,
        onAddTaskClick = onAddTaskClick,
        onIntent = viewModel::onIntent
    )
}

@Composable
private fun TaskListScreenContent(
    state: TaskListScreenState,
    onItemClick: (Long) -> Unit,
    onAddTaskClick: () -> Unit,
    onIntent: (TaskListScreenIntent) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = "Список задач",
                style = MaterialTheme.typography.titleLarge,
            )

            if (state.isLoading) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
            }

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(items = state.tasks, key = { it.id }) { task ->
                    TaskItem(
                        task = task,
                        onClick = { onItemClick(task.id) },
                        onDelete = { onIntent(TaskListScreenIntent.DeleteTask(task.id)) },
                        changeStatus = {
                            onIntent(
                                TaskListScreenIntent.ChangeStatus(
                                    task.id,
                                    task.isCompleted
                                )
                            )
                        },
                    )
                }
            }
        }

        FloatingActionButton(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(bottom = 16.dp),
            onClick = onAddTaskClick,
            content = { Icon(Icons.Default.Add, null) })
    }
}
