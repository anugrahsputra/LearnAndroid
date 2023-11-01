package com.downormal.articlecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.downormal.articlecompose.ui.theme.ArticleComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArticleComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ShowArticle()
                }
            }
        }
    }
}

@Composable
fun ShowArticle() {
    val title = stringResource(R.string.title_jetpack_compose_tutorial)
    val shortDesc = stringResource(R.string.compose_short_desc)
    val longDesc = stringResource(R.string.compose_long_desc)
    val image = painterResource(R.drawable.bg_compose_background)
    Article(
        title = title,
        shortDesc = shortDesc,
        longDesc = longDesc,
        imagePainter = image
    )
}

@Composable
fun Article(
    title: String,
    shortDesc: String,
    longDesc: String,
    imagePainter: Painter,
    modifier: Modifier = Modifier,
) {
    Column {
        Image(painter = imagePainter, contentDescription = null)
        Text(
            text = title,
            fontSize = 24.sp,
            modifier = Modifier.padding(16.dp)
        )
        Text(
            text = shortDesc,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp),
            textAlign = TextAlign.Justify,
        )
        Text(
            text = longDesc,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp),
            textAlign = TextAlign.Justify,
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    ArticleComposeTheme {
        ShowArticle()
    }
}