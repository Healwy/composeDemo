package com.xuniyishifanchen.composedemo.ui.pages


import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.xuniyishifanchen.composedemo.model.entity.NavigationItem

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainPage() {

    val navigationItems = listOf(
        NavigationItem("学习", Icons.Filled.Home),
        NavigationItem("任务", Icons.Filled.DateRange),
        NavigationItem("我的", Icons.Filled.Person),
    )
    var currentNavigationIndex by remember {
        mutableStateOf(1)
    }

    val systemUiController = rememberSystemUiController()
    LaunchedEffect(key1 = Unit) {
        systemUiController.setSystemBarsColor(Color.Transparent)
    }
    Scaffold(bottomBar = {
        BottomNavigation(
            backgroundColor = MaterialTheme.colors.background,
        ) {
            navigationItems.forEachIndexed { index, navigationItem ->
                BottomNavigationItem(
                    selected = index == currentNavigationIndex,
                    onClick = {
                        currentNavigationIndex = index
                    },
                    icon = {
                        Icon(imageVector = navigationItem.icon, contentDescription = "")
                    },
                    label = {
                        Text(navigationItem.title)
                    },
                    selectedContentColor = Color(0xff1491e7),
                    unselectedContentColor = Color(0xff999999)
                )
            }
        }
    }) {
        Box(modifier = Modifier.padding(it)) {
            when (currentNavigationIndex) {
                0 -> StudyPage()
                1 -> TaskPage()
                2 -> MimePage()
            }
        }
    }
}

@Preview
@Composable
fun MainPagePreview() {
    MainPage()
}

