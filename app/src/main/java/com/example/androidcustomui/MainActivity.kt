package com.example.androidcustomui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.androidcustomui.components.progress.CircleProgressBar
import com.example.androidcustomui.components.progress.ProgressBarData
import com.example.androidcustomui.ui.theme.AndroidCustomUITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidCustomUITheme {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            Color.Black
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Column(modifier = Modifier.fillMaxSize()) {
                        CircleProgressBar(
                            size = 80.dp,
                            progressBarData = ProgressBarData(
                                hasEdgeRound = true,
                                initProgress = 80f,
                                strokeWidth = 4.dp
                            )
                        ) {
                            LoadIUImage()
                        }
                        CircleProgressBar(
                            size = 100.dp,
                            progressBarData = ProgressBarData(
                                hasEdgeRound = true,
                                initProgress = 55f
                            )
                        ) {
                            LoadIUImage()
                        }
                        CircleProgressBar(
                            size = 200.dp,
                            progressBarData = ProgressBarData(
                                hasEdgeRound = true,
                                initProgress = 20f
                            )
                        ) {
                            LoadIUImage()
                        }
                    }

                }

            }
        }
    }
}

@Composable
fun LoadIUImage() {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data("https://blog.kakaocdn.net/dn/bfsErb/btrgA5ljO5d/8PQ5EAMbrrgcnWsOqgf3y1/img.jpg")
            .crossfade(true)
            .size(800)
            .build(),
        contentDescription = "",
        contentScale = ContentScale.Crop,
        modifier = Modifier.clip(CircleShape),
    )
}

