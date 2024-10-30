package com.example.articlepractice1

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.articlepractice1.ui.theme.ArticlePractice1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArticlePractice1Theme {
                ArticleImage(
                    slogan = stringResource(R.string.slogan),
                    article = stringResource(R.string.article),
                    mainHalf = stringResource(R.string.main_half)
                )
            }
        }
    }
}

@Composable
fun ArticleText(slogan: String, article: String, mainHalf: String, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .padding(16.dp),
        content = {
        Text(
            text = slogan,
            fontSize = 26.sp,
            modifier = Modifier
                .padding(top = 12.dp, start = 6.dp, end = 6.dp)
        )
        Text(
            text = article,
            modifier = Modifier
                .padding(top = 16.dp, start = 6.dp, end = 6.dp)
        )
        Text(
            text = mainHalf,
            modifier = Modifier
                .padding(top = 16.dp, start = 6.dp, end = 6.dp)
        )
    }
    )
}

@Composable
fun ArticleImage(slogan: String, article: String, mainHalf: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.article_image)
    Box(modifier) {
        Column{
            Image (
                painter = image,
                contentDescription = null, // для слепых говорим чтобы они не видели изображение
                alpha = 1.0F
            )
            ArticleText(
                slogan = stringResource(R.string.slogan),
                article = stringResource(R.string.article),
                mainHalf = stringResource(R.string.main_half)

            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ArticlePreview() {
    ArticlePractice1Theme {
        ArticleImage(slogan = stringResource(R.string.slogan), article = stringResource(R.string.article), mainHalf = stringResource(R.string.main_half))
    }
}