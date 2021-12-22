package com.example.composeapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight

//@Composable
//fun CardItem() {
//    Card(
//        modifier = Modifier
//            .fillMaxWidth()
//            .height(IntrinsicSize.Max)
//            .padding(16.dp),
//        shape = RoundedCornerShape(12.dp)
//    ) {
//        Column(
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            Row(modifier = Modifier.padding(12.dp)) {
//                Text(
//                    text = "You have an appointment now",
//                    style = MaterialTheme.typography.h5,
//                    color = colorResource(id = R.color.black_111)
//                )
//                Text(
//                    text = "Happening now",
//                    style = MaterialTheme.typography.body1,
//                    color = colorResource(id = R.color.blue_8ff),
//                )
//            }
//            Row(modifier = Modifier.padding(start = 12.dp)) {
//                Image(
//                    painterResource(id = R.drawable.default_avatar),
//                    contentDescription = "avatar"
//                )
//                Column() {
//                    Text(text = "Kim Torres", style = MaterialTheme.typography.h3)
//                    Text(
//                        text = "Makati Medical Center",
//                        style = MaterialTheme.typography.h5,
//                        color = colorResource(id = R.color.grey_d7d)
//                    )
//                    Text(
//                        text = "Feb 10, 2021 10:00 am",
//                        style = MaterialTheme.typography.h5,
//                        color = colorResource(id = R.color.grey_d7d)
//                    )
//                }
//                Image(painterResource(id = R.drawable.ic_grey_arrow), contentDescription = null)
//            }
//
//            Text(
//                text = "Enter consultation",
//                style = MaterialTheme.typography.h5,
//                fontWeight = FontWeight.W500
//            )
//        }
//    }
//}