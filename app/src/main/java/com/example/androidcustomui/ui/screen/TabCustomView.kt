package com.example.androidcustomui.ui.screen

import androidx.compose.runtime.Composable
import com.example.androidcustomui.components.common.MenuList

@Composable
fun TabCustomView(
    navigationToDetail: () -> Unit
) {
    MenuList(
        listOf<String>(
            "Stagger\nGridView"
        )
    )
}
