package com.example.composeapp.ui.theme.view.home.recordcard

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource

import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import com.example.composeapp.R
import com.example.composeapp.data.database.model.Item
import com.example.composeapp.data.database.model.helper.RecordType
import com.example.composeapp.utils.TeleDoctorHelper

@Composable
fun CardItem(navController: NavController, record: Item, currentTime: String) {
    Card(
        Modifier
            .padding(top = 12.dp, start = 12.dp, end = 12.dp)
            .clickable {
                navController.navigate("recordDetail")
            },
        shape = RoundedCornerShape(12.dp),
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
                    text = getStatus(
                        TeleDoctorHelper.convertRecordStatus(
                            record.status,
                            currentTime,
                            record.start,
                            record.end
                        )
                    ),
                    style = MaterialTheme.typography.body1,
                    color = colorResource(id = R.color.blue_8ff),
                )
            }
            RecordCardContent()
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

fun getStatus(recordType: Int): String {
    return when (recordType) {
        RecordType.TYPE_UPCOMING -> {
            "Upcoming"
        }
        RecordType.TYPE_HAPPENING_NOW -> {
            "Happening now"
        }
        RecordType.TYPE_COMPLETED -> {
            "Completed"
        }
        RecordType.TYPE_CANCELLED -> {
            "Cancelled"
        }
        RecordType.TYPE_MISSED -> {
            "Missed"
        }

        RecordType.TYPE_HAPPENING_SOON -> {
            "Happening Soon"
        }
        RecordType.TYPE_BOOKING -> {
            "Booking"
        }
        RecordType.TYPE_PENDING_RESULT -> {
            "Pending Result"
        }
        else -> {
            ""
        }
    }
}
