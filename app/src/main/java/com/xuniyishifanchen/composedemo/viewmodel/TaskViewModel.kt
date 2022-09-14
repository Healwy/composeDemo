package com.xuniyishifanchen.composedemo.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class TaskViewModel : ViewModel() {
    var taskDate by mutableStateOf("学习周期：2022.01.01-2022.12.31")
        private set

    val totalPoint = 1350
    var point by mutableStateOf(1000)

    var pointPercent by mutableStateOf(point / totalPoint.toFloat())
}