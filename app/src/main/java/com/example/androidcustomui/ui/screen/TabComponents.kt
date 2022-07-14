package com.example.androidcustomui.ui.screen

import androidx.compose.runtime.Composable
import com.example.androidcustomui.components.common.MenuList

@Composable
fun TabComponents(
    navigateToDetail: () -> Unit
) {
    MenuList(
        listOf<String>(
            "Circle\nProgressBar"
        )
    )
}