package com.example.featureone.impl

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Preview(showBackground = true)
@Composable
fun FeatureOneScreenPreview() {
    FeatureOneScreen(
        onItemClick = {}
    )
}

@Composable
internal fun FeatureOneScreen(
    modifier: Modifier = Modifier,
    onItemClick: (String) -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
        ) {
            items(
                count = 50,
                key = { it },
            ) {
                Text(
                    text = "Item $it",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .background(Color.Red.copy(alpha = 0.2f))
                        .clickable { onItemClick(it.toString()) },
                )
            }
        }
    }
}
