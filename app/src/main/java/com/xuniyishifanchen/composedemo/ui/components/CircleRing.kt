package com.xuniyishifanchen.composedemo.ui.components


import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp

@Composable
fun CircleRing(size: Int, strokeWidth: Float = 30f, percent: Float = 0.2f) {

    Canvas(modifier = Modifier.size(size.dp)) {
        drawArc(
            color = Color(0, 0, 0, 15),
            startAngle = 160f,
            sweepAngle = 220f,
            useCenter = false,
            style = Stroke(strokeWidth, cap = StrokeCap.Round)
        )

        drawArc(
            color = Color.White,
            startAngle = 160f,
            sweepAngle = 220f * percent,
            useCenter = false,
            style = Stroke(strokeWidth, cap = StrokeCap.Round)
        )
    }
}