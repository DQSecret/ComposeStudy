package com.example.composestudy.study

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composestudy.R

@Composable
fun Greeting(name: String) {
    Text(text = name)
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFF)
@Composable
fun PreviewGreeting() {
    Greeting(name = "DQ For Olivia~~~")
}

@Composable
fun NewsStory() {
    MaterialTheme {
        val typography = MaterialTheme.typography
        Column {
            Image(
                painter = painterResource(R.drawable.header),
                contentDescription = null,
                modifier = Modifier
                    .height(180.dp)
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(4.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                "A day wandering through the sand hills in Shark Fin Cove, and a few of the sights I saw",
                style = typography.titleMedium,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                "Davenport, California",
                style = typography.bodySmall
            )
            Text(
                "December 2018",
                style = typography.bodySmall
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFF)
@Composable
fun PreviewNewsStory() {
    NewsStory()
}

@Composable
fun GotoNextPage(text: String, goto: () -> Unit) {
    Button(onClick = goto) {
        Text(text = text)
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFF)
@Composable
fun PreviewGotoNextPage() {
    val text = "跳转到 CodeLab 页面"
    val context = LocalContext.current
    GotoNextPage(text = text, goto = {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
    })
}