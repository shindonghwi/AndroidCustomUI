package com.example.androidcustomui.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.style.TextAlign

@Composable
fun TabCustomView(
    navigationToDetail: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.primary)
    ) {
        Text(
            text = "TabCustomView",
            style = MaterialTheme.typography.h1,
            textAlign = TextAlign.Center,
            color = White,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}