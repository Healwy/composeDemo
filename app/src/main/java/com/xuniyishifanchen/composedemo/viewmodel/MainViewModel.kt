package com.xuniyishifanchen.composedemo.viewmodel

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.xuniyishifanchen.composedemo.model.entity.Catgegory
import com.xuniyishifanchen.composedemo.model.entity.DataType
import com.xuniyishifanchen.composedemo.model.entity.SwipeEntity

class MainViewModel : ViewModel() {

    val category = mutableStateListOf<Catgegory>(
        Catgegory("思想政治"),
        Catgegory("法律法规"),
        Catgegory("职业道德"),
        Catgegory("诚信自律")
    )

    var categoryIndex by mutableStateOf(0)
        private set

    fun updateCategoryIndex(index: Int) {
        categoryIndex = index
    }

    val datatype = mutableStateListOf<DataType>(
        DataType("相关资讯", Icons.Default.Person),
        DataType("视频课程", Icons.Default.Favorite)
    )

    var dataTypeIndex by mutableStateOf(0)
        private set

    fun updateDataTypeIndex(index: Int) {
        dataTypeIndex = index
    }

    val swiperData = listOf(
        SwipeEntity("https://docs.bughub.icu/compose/assets/banner4.jpg"),
        SwipeEntity("https://img0.baidu.com/it/u=3008617848,2902960850&fm=253&fmt=auto&app=138&f=JPEG?w=360&h=360"),
        SwipeEntity("https://img0.baidu.com/it/u=3047251996,1492990240&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=500"),
    )

    val notications = listOf(
        "人社部向疫情防控期",
        "湖北黄冈新冠肺炎患者治愈病例破千连续5治愈病例破千连续5",
        "安徽单日新增确诊病例首次降至个位数累计"
    )

}