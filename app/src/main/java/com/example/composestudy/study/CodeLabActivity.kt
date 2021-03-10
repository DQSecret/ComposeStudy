package com.example.composestudy.study

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composestudy.ui.theme.BasicsCodeLabTheme

class CodeLabActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CodeLabActivityContent()
        }
    }

    @Composable
    fun CodeLabActivityContent() {
        BaseTheme {
            Column {
                GreetingList()
                Spacer(modifier = Modifier.height(24.dp))
                val count = remember { mutableStateOf(0) }
                Counter(count.value) { count.value = it }
            }
        }
    }

    @Composable
    fun BaseTheme(content: @Composable () -> Unit) {
        BasicsCodeLabTheme {
            Surface(
                color = MaterialTheme.colors.surface,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
            ) {
                content()
            }
        }
    }

    @Composable
    fun GreetingList(names: List<String> = listOf("DQ", "Olivia")) {
        Column {
            names.forEach {
                Greeting(name = it)
                Divider()
            }
        }
    }

    @Composable
    fun Greeting(name: String) {
        Text(text = "Hello $name~", modifier = Modifier.padding(24.dp))
    }

    @Composable
    fun Counter(count: Int, updatedCount: (Int) -> Unit) {
        Button(
            onClick = { updatedCount(count + 1) },
            modifier = Modifier.padding(start = 24.dp)
        ) {
            Text(text = "点击次数统计器 -> ${count}.")
        }
    }

    @Preview
    @Composable
    fun DefaultPreview() {
        CodeLabActivityContent()
    }
}