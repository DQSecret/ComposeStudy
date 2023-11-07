package com.example.composestudy.study

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composestudy.ui.theme.ComposeStudyTheme

class CodeLabActivity : ComponentActivity() {

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
                val count = remember { mutableIntStateOf(0) }
                Counter(count.intValue) { count.intValue = it }
            }
        }
    }

    @Composable
    fun BaseTheme(content: @Composable () -> Unit) {
        ComposeStudyTheme {
            Surface(
                color = MaterialTheme.colorScheme.surface,
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