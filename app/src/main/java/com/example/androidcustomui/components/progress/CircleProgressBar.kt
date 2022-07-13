package com.example.androidcustomui.components.progress

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


@Composable
fun CircleProgressBar(
    size: Dp,
    animationDuration: Int = 2000,
    borderData: CircleBorderData = CircleBorderData(),
    progressBarData: CircleProgressBarData = CircleProgressBarData(),
    centerComposable: @Composable (() -> Unit)? = null,
) {
    val initProgress = progressBarData.initProgress
    val strokeWidth = progressBarData.strokeWidth
    val disableColor = progressBarData.disableColor
    val enableColor = progressBarData.enableColor
    val hasEdgeRound = progressBarData.hasEdgeRound
    val borderColor = borderData.borderColor
    val borderStroke = borderData.strokeWidth

    /** 1.프로그래스바 remember value 셋팅
    렌더링 시에 사용자가 요청한 초기값으로 프로그래스바 진행 */
    var progressValue by remember { mutableStateOf(0f) }
    val progressAnimating = animateFloatAsState(
        targetValue = progressValue,
        animationSpec = tween(
            durationMillis = animationDuration
        )
    )
    LaunchedEffect(Unit) { progressValue = initProgress }

    /**
     * 원 그리기
     * 1. Shadow 그리기
     * 2. 내부 원 그리기
     * 3. 호 그리기
     */
    Box(
        modifier = Modifier
            .size(size),
        contentAlignment = Alignment.Center
    ) {
        Canvas(
            modifier = Modifier
                .size(size)
        ) {
            val width = this.size.width
            val height = this.size.height

            // 원 테두리 Stroke 설정
            drawCircle(
                color = borderColor,
                radius = (width / 2f) + borderStroke.toPx(),
                center = Offset(x = width / 2, y = height / 2),
            )

            // 바깥 원 Shadow
            drawCircle(
                color = disableColor,
                radius = height / 2,
                center = Offset(x = width / 2, y = height / 2),
            )

            // 내부 원
            if (centerComposable == null) {
                drawCircle(
                    color = Color.White,
                    radius = (size / 2 - strokeWidth).toPx(),
                    center = Offset(x = width / 2, y = height / 2)
                )
            }

            // 호 그리기 ( progressBar )
            drawArc(
                color = enableColor,
                startAngle = -90f,
                sweepAngle = (progressAnimating.value) * 360 / 100,
                useCenter = false,
                style = Stroke(
                    width = strokeWidth.toPx(),
                    cap = if (hasEdgeRound) {
                        StrokeCap.Round
                    } else {
                        StrokeCap.Butt
                    }
                ),
                size = Size(
                    width = (size - strokeWidth).toPx(),
                    height = (size - strokeWidth).toPx()
                ),
                topLeft = Offset(
                    x = (strokeWidth / 2).toPx(),
                    y = (strokeWidth / 2).toPx()
                )
            )
        }
        centerComposable?.let {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(all = progressBarData.strokeWidth)
                    .clip(CircleShape),
                contentAlignment = Alignment.Center
            ) {
                it()
            }
        }
    }
}

data class CircleProgressBarData(
    val initProgress: Float = 50f,
    val strokeWidth: Dp = 8.dp,
    val disableColor: Color = Color(0xFFD2DAE2),
    val enableColor: Color = Color(0xFFFF5E57),
    val hasEdgeRound: Boolean = false
)

data class CircleBorderData(
    val strokeWidth: Dp = 0.dp,
    val borderColor: Color = Color(0xFF000000)
)