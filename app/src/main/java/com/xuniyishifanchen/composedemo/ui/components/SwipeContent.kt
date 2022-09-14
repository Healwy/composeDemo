package com.xuniyishifanchen.composedemo.ui.components


import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.xuniyishifanchen.composedemo.viewmodel.MainViewModel
import kotlinx.coroutines.launch
import java.util.*

@OptIn(ExperimentalPagerApi::class)
@Composable
fun SwipeContent(vm: MainViewModel) {
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
    HorizontalPager(
        count = virtualIndex,
        modifier = Modifier
            .padding(horizontal = 6.dp)
            .clip(RoundedCornerShape(8.dp)),
        state = pagerState
    ) { index ->
        AsyncImage(
            model = vm.swiperData[index % vm.swiperData.size].imageUrl,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(16 / 9f),
            contentScale = ContentScale.Crop
        )
    }
}

