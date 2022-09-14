package com.xuniyishifanchen.composedemo.ui.components


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.VerticalPager
import com.google.accompanist.pager.rememberPagerState
import com.xuniyishifanchen.composedemo.viewmodel.MainViewModel
import kotlinx.coroutines.launch
import java.util.*

@OptIn(ExperimentalPagerApi::class)
@Composable
fun NotificationContnet(vm: MainViewModel) {

    val virtualIndex = Int.MAX_VALUE

    val initialIndex = virtualIndex / 2

    val pagerState = rememberPagerState(initialPage = initialIndex)

    val coroutine = rememberCoroutineScope()
    DisposableEffect(Unit) {
        val time = Timer()
        time.schedule(object : TimerTask() {
            override fun run() {
                coroutine.launch {
                    pagerState.animateScrollToPage(pagerState.currentPage + 1)
                }
            }
        }, 2000, 2000)
        onDispose {
            time.cancel()
        }
    }

    Row(
        modifier = Modifier
            .padding(8.dp)
            .clip(RoundedCornerShape(4.dp))
            .background(Color(0x22149ee7))
            .padding(horizontal = 4.dp)
            .clip(RoundedCornerShape(8.dp))
            .height(45.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "最新活动",
            color = Color(0xff149ee7),
            fontSize = 14.sp
        )
        VerticalPager(
            count = virtualIndex,
            modifier = Modifier
                .weight(1f)
                .padding(start = 8.dp),
            state = pagerState,
            horizontalAlignment = Alignment.Start
        ) { index ->
            Text(
                text = vm.notications[index % vm.notications.size],
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
        }
        Text(
            text = "更多",
            color = Color(0xff666666),
            fontSize = 14.sp,
            maxLines = 1
        )
    }
}



