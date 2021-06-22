package com.example.composestudy.rengwuxian.widgets

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*

@Composable
fun TestClick() {
    var num by remember { mutableStateOf(1) }
    Button(onClick = { num++ }) {
        Text(
            text = "当前的值是 $num"
        )
    }
}