package com.xuniyishifanchen.composedemo.ui.components


import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import coil.compose.AsyncImage
import com.xuniyishifanchen.composedemo.model.entity.VideoEntity

@Composable
fun VideoItem(videoEntity: VideoEntity) {
    val constrainSet = ConstraintSet {
        val cover = createRefFor("cover")
        val title = createRefFor("title")
        val type = createRefFor("type")
        val duration = createRefFor("duration")
        val divider = createRefFor("divider")

        constrain(cover) {
            start.linkTo(parent.start)
            centerVerticallyTo(parent)
        }

        constrain(title) {
            start.linkTo(cover.end, margin = 8.dp)
            top.linkTo(cover.top)
            end.linkTo(parent.end)
            width = Dimension.fillToConstraints
        }

        constrain(type) {
            start.linkTo(cover.end, margin = 8.dp)
            bottom.linkTo(cover.bottom)
        }

        constrain(duration) {
            start.linkTo(type.end, margin = 8.dp)
            bottom.linkTo(cover.bottom)
        }
        constrain(divider) {
            top.linkTo(cover.bottom, margin = 8.dp)
        }
    }
    ConstraintLayout(constrainSet, modifier = Modifier.fillMaxWidth()) {
        AsyncImage(
            model = videoEntity.imageUrl,
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .width(111.5.dp)
                .aspectRatio(16 / 9f)
                .layoutId("cover")
                .clip(RoundedCornerShape(8.dp))
        )

        Text(
            text = videoEntity.title,
            fontSize = 16.sp,
            color = Color(0xFF333333),
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.layoutId("title")
        )
        Text(
            text = videoEntity.type,
            fontSize = 10.sp,
            color = Color(0xFF999999),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.layoutId("type")
        )

        Text(
            text = videoEntity.duration,
            fontSize = 10.sp,
            color = Color(0xFF999999),
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.layoutId("duration")
        )

        Divider(modifier = Modifier.layoutId("divider"))
    }
}

