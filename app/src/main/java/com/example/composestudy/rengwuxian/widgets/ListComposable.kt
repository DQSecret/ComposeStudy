package com.example.composestudy.rengwuxian.widgets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun TestClick() {
    var num by remember { mutableStateOf(1) }
    Button(onClick = { num++ }) {
        Text(
            text = "当前的值是 $num"
        )
    }
}

private var numbers by mutableStateOf(mutableListOf(1, 2, 3))
private var flag by mutableStateOf(1)

// 会监听内部元素的变化
private val numbersObs = mutableStateListOf<Int>(1, 2, 3)
private val mapObs = mutableStateMapOf(1 to "one", 2 to "two", 3 to "three")

@Composable
fun TestList() {
    Column(modifier = Modifier.padding(8.dp)) {
        Text(text = "强制刷新:$flag", modifier = Modifier.clickable { flag++ })

        Divider(color = Color.Transparent, thickness = 4.dp)

        Button(
            onClick = { numbers.add(numbers.last() + 1) },
        ) {
            Text(text = "加 1")
        }

        Divider(color = Color.Transparent, thickness = 4.dp)

        for (num in numbers) {
            Text(text = "第 $num 块文字")
        }

        Button(
            onClick = {
                numbers = numbers.toMutableList().apply {
                    add(numbers.last() + 1)
                }
            },
        ) {
            Text(text = "复制元素添加 - 加 1")
        }

        Divider(color = Color.Transparent, thickness = 4.dp)

        Button(
            onClick = { numbersObs.add(numbersObs.last() + 1) },
        ) {
            Text(text = "优雅的加 1")
        }
        for (num in numbersObs) {
            Text(text = "第 $num 块文字")
        }
    }
}