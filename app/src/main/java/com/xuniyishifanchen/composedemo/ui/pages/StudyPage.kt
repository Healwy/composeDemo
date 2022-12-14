package com.xuniyishifanchen.composedemo.ui.pages


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.LeadingIconTab
import androidx.compose.material.Surface
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.xuniyishifanchen.composedemo.ui.components.ArticleItem
import com.xuniyishifanchen.composedemo.ui.components.NotificationContnet
import com.xuniyishifanchen.composedemo.ui.components.SwipeContent
import com.xuniyishifanchen.composedemo.ui.components.TopAppBar
import com.xuniyishifanchen.composedemo.ui.components.VideoItem
import com.xuniyishifanchen.composedemo.viewmodel.ArticleViewModel
import com.xuniyishifanchen.composedemo.viewmodel.MainViewModel
import com.xuniyishifanchen.composedemo.viewmodel.VideoViewModel

@OptIn(ExperimentalPagerApi::class)
@Composable
fun StudyPage(
    vm: MainViewModel = viewModel(),
    articleVm: ArticleViewModel = viewModel(),
    videoViewModel: VideoViewModel = viewModel()
) {
    Column() {
        TopAppBar {
            Spacer(modifier = Modifier.width(10.dp))
            Surface(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .weight(1f),
                color = Color(0x66FFFFFF)
            ) {
                Row(modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "",
                        tint = Color.White
                    )
                    Text(
                        text = "?????????????????????????????????",
                        fontSize = 16.sp,
                        color = Color.White,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
            Spacer(modifier = Modifier.width(10.dp))
            Text(text = "??????\n??????", color = Color.White, fontSize = 16.sp)
            Spacer(modifier = Modifier.width(10.dp))
            Icon(
                imageVector = Icons.Default.Notifications,
                contentDescription = "",
                tint = Color.White
            )
            Spacer(modifier = Modifier.width(10.dp))
        }

        TabRow(
            selectedTabIndex = vm.categoryIndex,
            backgroundColor = Color(0X22149EE7),
            contentColor = Color(0XFF149EE7)
        ) {
            vm.category.forEachIndexed { index, category ->
                Tab(
                    selected = vm.categoryIndex == index,
                    onClick = { vm.updateCategoryIndex(index) },
                    selectedContentColor = Color(0XFF149EE7),
                    unselectedContentColor = Color(0XFF666666)
                ) {
                    Text(
                        text = category.title,
                        modifier = Modifier.padding(vertical = 8.dp),
                        fontSize = 14.sp
                    )
                }
            }
        }

        TabRow(
            selectedTabIndex = vm.dataTypeIndex,
            backgroundColor = Color.Transparent,
            contentColor = Color(0xff149ee7),
            indicator = {},
            divider = {}
        ) {
            vm.datatype.forEachIndexed { index, item ->
                LeadingIconTab(
                    selected = vm.dataTypeIndex == index,
                    onClick = { vm.updateDataTypeIndex(index) },
                    selectedContentColor = Color(0xff149ee7),
                    unselectedContentColor = Color(0xff666666),
                    text = {
                        Text(
                            text = "${item.title}",
                            modifier = Modifier.padding(vertical = 8.dp),
                            fontSize = 14.sp
                        )
                    },
                    icon = {
                        Icon(imageVector = item.icon, contentDescription = "")
                    }
                )
            }
        }

        LazyColumn() {
            item { SwipeContent(vm) }
            item { NotificationContnet(vm) }
            if (vm.dataTypeIndex == 0) {
                items(articleVm.articles) {
                    ArticleItem(articel = it)
                }
            } else {
                items(videoViewModel.list) { videoEntity ->
                    VideoItem(videoEntity)
                }
            }
        }

    }
}

@Preview
@Composable
fun StudyPagePreview() {
    StudyPage()
}

