package com.xuniyishifanchen.composedemo.ui.pages


import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.xuniyishifanchen.composedemo.ui.components.TopAppBar

@Composable
fun TaskPage() {
    Column() {
        TopAppBar {
            Text(text = "任务页")
        }
    }
}

@Preview
@Composable
fun TaskPagePreview() {
    TaskPage()
}

