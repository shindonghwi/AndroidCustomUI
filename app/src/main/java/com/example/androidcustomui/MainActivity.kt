package com.example.androidcustomui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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
                            Color.White
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.SpaceAround,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        CircleProgressBar(
                            size = 120.dp,
                            progressBarData = ProgressBarData(
                                hasEdgeRound = true,
                                initProgress = 30f,
                                strokeWidth = 20.dp
                            )
                        ) {
                            LoadIUImage(
                                imageUrl = "https://t1.daumcdn.net/cfile/tistory/267AF84F56380F0B14"
                            )
                        }
                        CircleProgressBar(
                            size = 180.dp,
                            progressBarData = ProgressBarData(
                                hasEdgeRound = false,
                                enableColor = Color.Blue,
                                initProgress = 50f,
                                strokeWidth = 20.dp
                            )
                        ) {
                            LoadIUImage(
                                imageUrl = "https://t1.daumcdn.net/cfile/blog/13648E444FB99AAC0F"
                            )
                        }
                        CircleProgressBar(
                            size = 240.dp,
                            progressBarData = ProgressBarData(
                                hasEdgeRound = true,
                                enableColor = Color.Magenta,
                                initProgress = 90f
                            )
                        ) {
                            LoadIUImage(
                                imageUrl = "https://cdn.ppomppu.co.kr/zboard/data3/2020/0803/20200803184230_sbzqnfne.jpg"
                            )
                        }
                    }

                }

            }
        }
    }
}

@Composable
fun LoadIUImage(imageUrl: String) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(imageUrl)
            .crossfade(true)
            .size(800)
            .build(),
        contentDescription = "",
        contentScale = ContentScale.Crop,
        modifier = Modifier.clip(CircleShape),
    )
}

