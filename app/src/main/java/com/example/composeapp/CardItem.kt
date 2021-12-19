package com.example.composeapp

import android.widget.ImageView
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun CardItem() {
    val popFontFamily = FontFamily(
        Font(R.font.poppins_medium, FontWeight.Normal),
        Font(R.font.poppins_regular, FontWeight.Normal),
    )
    Card(
        shape = RoundedCornerShape(12.dp)
    ) {
        Column {
            Row(modifier = Modifier.padding(12.dp)) {
                Text(text = "You have an appointment now")
                Text(text = "Happening now")
            }
            Row(modifier = Modifier.padding(12.dp)) {
                Image(
                    painterResource(id = R.drawable.default_avatar),
                    contentDescription = "avatar"
                )
                Column() {
                    Text(text = "Kim Torres", fontFamily = popFontFamily, fontSize = 18.sp)
                    Text(text = "Makati Medical Center", fontFamily = popFontFamily)
                    Text(text = "Feb 10, 2021 10:00 am", fontFamily = popFontFamily)
                }
                Image(painterResource(id = R.drawable.ic_grey_arrow), contentDescription = null)
            }

            Text(text = "Enter consultation")
        }
    }
}