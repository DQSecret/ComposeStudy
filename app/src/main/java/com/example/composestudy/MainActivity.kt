package com.example.composestudy

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import com.example.composestudy.study.Greeting
import com.example.composestudy.study.NewsStory
import com.example.composestudy.ui.theme.ComposeStudyTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeStudyTheme {
                Column {
                    Greeting(name = "DQ For Olivia~")
                    NewsStory()
                }
            }
        }
    }
}
