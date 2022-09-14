package com.xuniyishifanchen.composedemo.ui.components


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.xuniyishifanchen.composedemo.ui.theme.Blue200
import com.xuniyishifanchen.composedemo.ui.theme.Blue700

@Composable
fun TopAppBar(content: @Composable () -> Unit) {
    val statusBarHeight = with(LocalDensity.current) {
        WindowInsets.systemBars.getTop(this).toDp()
    }
    Row(
        modifier = Modifier
            .background(
                Brush.linearGradient(
                    listOf(Blue700, Blue200)
                )
            )
            .fillMaxWidth()
            .height(46.dp + statusBarHeight)
            .padding(top = statusBarHeight),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        content()
    }

}

@Preview
@Composable
fun TopAppBarPreview() {
    TopAppBar {
        Text(text = "title")
    }
}

