package com.example.androidcustomui.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout

/**
 * Stagger Grid View [ 핀터레스트에서 구현한 UI ]
 *
 * @param modifier
 * @param numColumns: 열의 갯수
 * @param content: @Composable Function
 *
 */
@Composable
fun CustomStaggeredVerticalGrid(
    modifier: Modifier = Modifier,
    numColumns: Int = 2,
    content: @Composable () -> Unit
) {
    Layout(
        content = content,
        modifier = modifier
    ) { measurable, constraints ->

        // 한 열의 가로 길이를 구한다.
        val columnWidth = (constraints.maxWidth / numColumns)

        // 아이템 위젯을 만들고 초기화한다.
        val itemConstraints = constraints.copy(maxWidth = columnWidth)
        val columnHeights = IntArray(numColumns) { 0 }

        val placeables = measurable.map { measurable ->
            val column = testColumn(columnHeights)
            val placeable = measurable.measure(itemConstraints)

            columnHeights[column] += placeable.height
            placeable
        }

        val height = columnHeights.maxOrNull()?.coerceIn(constraints.minHeight, constraints.maxHeight)
                ?: constraints.minHeight

        layout(
            width = constraints.maxWidth,
            height = height
        ) {
            val columnYPointers = IntArray(numColumns) { 0 }

            placeables.forEach { placeable ->
                val column = testColumn(columnYPointers)

                placeable.place(
                    x = columnWidth * column,
                    y = columnYPointers[column]
                )
                columnYPointers[column] += placeable.height
            }
        }
    }
}


private fun testColumn(columnHeights: IntArray): Int {
    var minHeight = Int.MAX_VALUE
    var columnIndex = 0

    columnHeights.forEachIndexed { index, height ->
        if (height < minHeight) {
            minHeight = height
            columnIndex = index
        }
    }
    return columnIndex
}