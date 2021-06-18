package com.example.composestudy.rengwuxian.widgets

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

@Composable
fun TestText() {
    Column {
        TestText1()
        TestText2()
        ShowCharCount("DQ")
        ShowCharCount("Dana")
    }
}

// mutableStateOf 会自动触发订阅&更新
val name by mutableStateOf("DQ")

@Composable
private fun TestText1() {
    Text(text = name)
}

@Composable
private fun TestText2() {
    // 内部的话，需要使用 remember 包裹. remember=>仅一次初始化,会缓存
    val name by remember { mutableStateOf("DQ") }
    Text(text = name)
}

@Composable
fun ShowCharCount(value: String) {
    // 重复计算，需要尽量避免
    Text("①字符串($value)的长度是 ${value.length}")
    // 会防止重复执行
    val length2 = remember { value.length }
    Text("②字符串($value)的长度是 $length2")
    // 需要更新时，是需要重复执行的，带key的缓存方式
    val length3 = remember(value) { value.length } // key
    Text("③字符串($value)的长度是 $length3")
    val limit = 5
    val length4 = remember(value, limit) { value.length - limit } // 多个key
    Text("④字符串($value)的长度是 $length4")
}

// Composable「无状态」？
// 准确来说是「无(内部)状态」和 state-hoisting(状态上移)即把参数(状态值)提到外面(上层)去