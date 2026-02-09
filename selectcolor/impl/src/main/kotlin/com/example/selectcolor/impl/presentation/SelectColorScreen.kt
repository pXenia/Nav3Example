package com.example.selectcolor.impl.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun SelectColorScreen(
    stackSize: Int,
    onBack: () -> Unit,
    addNewScreen: () -> Unit,
    onResetToRoot: () -> Unit,
    viewModel: SelectColorViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()

    SelectColorScreenContent(
        stackSize = stackSize,
        onBack = onBack,
        addNewScreen = addNewScreen,
        onResetToRoot = onResetToRoot,
        state = state,
        onIntent = viewModel::onIntent
    )
}

@Composable
private fun SelectColorScreenContent(
    stackSize: Int,
    onBack: () -> Unit,
    addNewScreen: () -> Unit,
    onResetToRoot: () -> Unit,
    state: SelectColorScreenState,
    onIntent: (SelectColorScreenIntent) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(state.backGroundColor),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Текущий размер стека $stackSize",
            style = MaterialTheme.typography.headlineSmall
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Button(
                onClick = { onIntent(SelectColorScreenIntent.ShowDialog) },
            ) {
                Text(text = "Выбрать цвет")
            }

            Button(
                onClick = addNewScreen,
            ) {
                Text(text = "Создать еще экран")
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Button(
                onClick = onBack,
                enabled = stackSize > 1
            ) {
                Text(text = "Назад")
            }

            Button(
                onClick = onResetToRoot,
                enabled = stackSize > 1
            ) {
                Text(text = "Удалить все созданные экраны")
            }
        }

        if (state.isSelectColorDialogVisible) {
            SelectColorDialog(
                onDismiss = { onIntent(SelectColorScreenIntent.HideDialog) },
                onConfirm = { r, g, b ->
                    onIntent(SelectColorScreenIntent.ApplyColor(r, g, b))
                }
            )
        }
    }
}

@Composable
private fun SelectColorDialog(
    onDismiss: () -> Unit,
    onConfirm: (Int, Int, Int) -> Unit
) {
    var r by remember { mutableStateOf("") }
    var g by remember { mutableStateOf("") }
    var b by remember { mutableStateOf("") }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Введите RGB код цвета") },
        text = {
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                RGBField(label = "Красный", value = r) { r = it }
                RGBField(label = "Зелёный", value = g) { g = it }
                RGBField(label = "Синий", value = b) { b = it }
            }
        },
        confirmButton = {
            Button(
                onClick = {
                    onConfirm(
                        r.toIntOrNull() ?: 0, g.toIntOrNull() ?: 0, b.toIntOrNull() ?: 0
                    )
                }) {
                Text("Применить")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) { Text("Отмена") }
        }
    )
}

@Composable
fun RGBField(label: String, hint: String = "0..255", value: String, onValueChange: (String) -> Unit) {
    OutlinedTextField(
        value = value,
        onValueChange = { if (it.length <= 3 && it.all { char -> char.isDigit() }) onValueChange(it) },
        label = { Text(label) },
        placeholder = { Text(hint) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        singleLine = true,
        modifier = Modifier.fillMaxWidth()
    )
}
