package com.example.composeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeapp.ui.theme.ComposeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    RecordList()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun RecordList() {
    LazyColumn {
        items(
            count = 3,
            itemContent = { CardItem() }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeAppTheme {
        RecordList()
    }
}

@Composable
fun CardItem() {
    Card(
        Modifier.padding(top = 12.dp, start = 12.dp, end = 12.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(
            Modifier
                .background(color = Color.White)
                .fillMaxWidth()
                .height(IntrinsicSize.Max)
        ) {
            Box(
                Modifier
                    .fillMaxWidth()
                    .height(IntrinsicSize.Max)
                    .padding(12.dp),

                ) {
                Text(
                    text = "You have an appointment now",
                    style = MaterialTheme.typography.h5,
                    color = colorResource(id = R.color.black_111)
                )
                Text(
                    modifier = Modifier.align(Alignment.CenterEnd),
                    text = "Happening now",
                    style = MaterialTheme.typography.body1,
                    color = colorResource(id = R.color.blue_8ff),
                )
            }
            Divider(thickness = 1.dp)
            Box(
                modifier = Modifier
                    .padding(start = 12.dp, end = 12.dp, top = 12.dp, bottom = 24.dp)
                    .fillMaxWidth()
                    .height(IntrinsicSize.Max),
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painterResource(id = R.drawable.default_avatar),
                        contentDescription = "avatar"
                    )
                    Column(Modifier.padding(start = 12.dp)) {
                        Text(text = "Kim Torres", style = MaterialTheme.typography.h3)
                        Text(

                            text = "Makati Medical Center",
                            style = MaterialTheme.typography.h5,
                            color = colorResource(id = R.color.grey_d7d)
                        )
                        Text(
                            text = "Feb 10, 2021 10:00 am",
                            style = MaterialTheme.typography.h5,
                            color = colorResource(id = R.color.grey_d7d)
                        )
                    }
                }

                Image(
                    modifier = Modifier.align(Alignment.CenterEnd),
                    painter = painterResource(id = R.drawable.ic_grey_arrow),
                    contentDescription = null
                )
            }
            Divider(thickness = 1.dp)
            Text(
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.CenterHorizontally),
                text = "Enter consultation",
                color = colorResource(id = R.color.grey_d7d),
                style = MaterialTheme.typography.h5,
                fontWeight = FontWeight.W500,
            )
        }
    }

}