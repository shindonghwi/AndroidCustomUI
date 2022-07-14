package com.example.androidcustomui.components.common

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.androidcustomui.utils.CustomStaggeredVerticalGrid


@Composable
fun MenuList(menus: List<String>) {

    CustomStaggeredVerticalGrid(
        numColumns = 2,
        modifier = Modifier.padding(20.dp)
    ) {
        menus.forEach { menu ->
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                LargeFloatingActionButton(onClick = { }) {
                    Text(
                        modifier = Modifier.padding(4.dp),
                        textAlign = TextAlign.Center,
                        text = menu
                    )
                }
            }
        }
    }
}
