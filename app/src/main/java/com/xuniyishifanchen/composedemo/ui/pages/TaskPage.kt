package com.xuniyishifanchen.composedemo.ui.pages


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.xuniyishifanchen.composedemo.ui.components.CircleRing
import com.xuniyishifanchen.composedemo.viewmodel.TaskViewModel

@Composable
fun TaskPage(taskVm: TaskViewModel = viewModel()) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    listOf(Color(0XFF149EE7), Color.White)
                )
            )
    ) {

        val statusBarHeight = with(LocalDensity.current) {
            WindowInsets.systemBars.getTop(this).toDp()
        }

        var boxWidthDp: Int
        with(LocalConfiguration.current) {
            boxWidthDp = screenWidthDp / 2
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = statusBarHeight)
                .height(48.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "学习任务",
                textAlign = TextAlign.Center,
                color = Color.White,
            )
        }

        LazyColumn() {
            item {
                Text(
                    text = taskVm.taskDate,
                    fontSize = 12.sp,
                    color = Color.White,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
            }

            item {
                Box(
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .background(Color.Yellow),
                    contentAlignment = Alignment.Center
                ) {
                    CircleRing(boxWidthDp, percent = taskVm.pointPercent)
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = buildAnnotatedString {
                                withStyle(SpanStyle(fontSize = 35.sp)) {
                                    append(taskVm.point.toString())
                                }
                                withStyle(SpanStyle(fontSize = 12.sp)) {
                                    append("分")
                                }
                            },
                            color = Color.White,
                            textAlign = TextAlign.Center
                        )
                        Text(text = "学年积分", fontSize = 12.sp, color = Color.White)
                    }
                }
            }
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Column() {
                        Text(
                            text = "${taskVm.totalPoint}分",
                            fontSize = 12.sp,
                            color = Color.White,
                        )
                        Text(
                            text = "学年规定积分", fontSize = 12.sp,
                            color = Color.White,
                        )
                    }
                    Column() {
                        Text(
                            text = "${taskVm.totalPoint - taskVm.point}分",
                            fontSize = 12.sp,
                            color = Color.White,
                        )
                        Text(
                            text = "还差", fontSize = 12.sp,
                            color = Color.White,
                        )
                    }
                }
            }


        }

    }
}

@Preview
@Composable
fun TaskPagePreview() {
    TaskPage()
}

