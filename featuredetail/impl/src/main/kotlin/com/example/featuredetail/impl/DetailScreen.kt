package com.example.featuredetail.impl

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true)
@Composable
fun DetailScreenPreview() {
    DetailScreen(id = "123", onButtonBackClick = {})
}

@Composable
internal fun DetailScreen(
    modifier: Modifier = Modifier,
    id: String,
    onButtonBackClick: () -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.LightGray),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(text = "ID - $id")
        Button(
            onClick = onButtonBackClick,
        ) {
            Text(text = "Назад")
        }
    }
}
