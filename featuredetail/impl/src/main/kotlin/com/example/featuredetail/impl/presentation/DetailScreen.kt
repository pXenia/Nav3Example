package com.example.featuredetail.impl.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel

@Preview(showBackground = true)
@Composable
fun DetailScreenPreview() {
}

@Composable
internal fun DetailScreen(
    modifier: Modifier = Modifier,
    id: String,
    onButtonBackClick: () -> Unit,
    viewModel: DetailScreenViewModel = hiltViewModel(),
) {
    LaunchedEffect(id) {
        viewModel.initialize(id)
    }

    val uiText by viewModel.uiState.collectAsState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.LightGray),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {

        uiText?.let { Text(text = it) }

        Button(
            onClick = onButtonBackClick,
        ) {
            Text(text = "Назад")
        }
    }
}
