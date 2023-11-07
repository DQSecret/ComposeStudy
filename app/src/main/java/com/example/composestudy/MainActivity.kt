package com.example.composestudy

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composestudy.rengwuxian.HenCoderActivity
import com.example.composestudy.study.CodeLabActivity
import com.example.composestudy.study.GotoNextPage
import com.example.composestudy.study.Greeting
import com.example.composestudy.study.NewsStory
import com.example.composestudy.ui.theme.ComposeStudyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeStudyTheme {
                Content()
            }
        }
    }

    private fun gotoCodeLabPage() {
        Intent(this@MainActivity, CodeLabActivity::class.java).run { startActivity(this) }
    }

    private fun gotoHenCoderPage() {
        Intent(this@MainActivity, HenCoderActivity::class.java).run { startActivity(this) }
    }

    @Composable
    fun Content() {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Greeting(name = "DQ For Olivia~")
            Spacer(modifier = Modifier.height(16.dp))
            NewsStory()
            Spacer(modifier = Modifier.height(16.dp))
            GotoNextPage(text = "跳转到 CodeLab 页面", goto = ::gotoCodeLabPage)
            Spacer(modifier = Modifier.height(16.dp))
            GotoNextPage(text = "跳转到 HenCoder 页面", goto = ::gotoHenCoderPage)
        }
    }

    @Preview(showBackground = true, backgroundColor = 0xFFFFFF)
    @Composable
    fun PreviewMainActivity() {
        Content()
    }
}
