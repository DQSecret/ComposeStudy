package com.example.composestudy.rengwuxian

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.composestudy.R
import com.example.composestudy.rengwuxian.widgets.ShowCharCount
import com.example.composestudy.rengwuxian.widgets.TestClick
import com.example.composestudy.rengwuxian.widgets.TestList
import kotlinx.coroutines.delay

class HenCoderActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyColumn(modifier = Modifier.fillMaxWidth(1f)) {
                item {
                    // 文本
                    Text(
                        text = "DQ"
                    )
                    // 本地图片
                    Image(
                        painter = painterResource(id = R.drawable.header),
                        contentDescription = "本地图片",
                        modifier = Modifier.size(50.dp)
                    )
                    // 网络图片
                    AsyncImage(
                        model = "https://picsum.photos/300/300",
                        contentDescription = "网络图片",
                        Modifier.size(50.dp)
                    )
                    // FrameLayout = Box
                    Box {}
                    // LinearLayout = Row | Column
                    Row {}
                    Column {}
                    // 1. 所有的属性设置，用这个 Modifier，
                    // 2. Compose 没有 Margin 属性
                    // 3. Modifier 对 属性顺序是敏感的
                    // 4. 通用属性设置用 Modifier，专用特性设置用 函数参数
                    // 5. Modifier.clickable 的触发范围，会被 padding 所影响
                    Column(
                        modifier = Modifier
                            .padding(8.dp)
                            .background(Color.Red)
                            .padding(8.dp)
                            .size(200.dp)
                    ) {
                        Text(
                            text = "DQ",
                            fontSize = 16.sp,
                            color = Color.Blue,
                            modifier = Modifier
                                .padding(8.dp)
                                .background(Color.Green, RoundedCornerShape(8.dp))
                                .padding(8.dp)
                        )
                        AsyncImage(
                            model = "https://picsum.photos/300/300",
                            contentDescription = "网络图片",
                            modifier = Modifier
                                // .clip(CircleShape)
                                .clip(RoundedCornerShape(100))
                                // .fillMaxWidth(0.5f)
                                .size(50.dp)
                                .clickable { toast() },
                        )
                        Button(
                            onClick = { toast() },
                            modifier = Modifier
                                .height(48.dp)
                                .padding(8.dp)
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                                contentDescription = "Icon"
                            )
                            Text(text = "测试按钮")
                        }
                    }
                    // RecyclerView = LazyRow | LazyColumn
                    LazyRow {}
                    val list = List(30) { "$it" }
                    LazyColumn(
                        modifier = Modifier
                            .size(100.dp)
                            .background(color = colorResource(id = android.R.color.holo_purple)),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        items(list) { item ->
                            Text(text = item)
                        }
                    }
                    Column {
                        var name by remember { mutableStateOf("DQ") }
                        ShowCharCount(value = name)
                        LaunchedEffect(name) {
                            delay(3000)
                            name = "DQDana"
                        }
                    }
                    Column {
                        TestClick()
                        TestList()
                    }
                }
            }
        }
    }

    private fun toast() {
        Toast.makeText(this@HenCoderActivity, "点击测试专用 Toast", Toast.LENGTH_SHORT).show()
    }
}