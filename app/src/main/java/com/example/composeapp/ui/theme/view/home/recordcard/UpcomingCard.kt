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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.annotation.ExperimentalCoilApi
import com.example.composeapp.R
import com.example.composeapp.data.database.model.Item
import com.example.composeapp.utils.TeleDoctorHelper
import com.example.composeapp.utils.TimeUtils
import java.util.concurrent.TimeUnit

@ExperimentalCoilApi
@Composable
fun UpcomingCard(navController: NavController, currentTime: String, record: Item) {
    var remainingTime = ""
    val time =
        TeleDoctorHelper.dateFormat(record.start ?: "")?.time ?: 0L
    val currentMill =
        TimeUtils.parseStringToTime(currentTime, TeleDoctorHelper.CURRENT_TIME)
    val currentTimeStamp: Long =
        if (currentMill == 0L) {
            System.currentTimeMillis()
        } else {
            currentMill
        }

    val remainDays = TimeUnit.MILLISECONDS.toDays(time - currentTimeStamp)
    val remainHours = TimeUnit.MILLISECONDS.toHours(time - currentTimeStamp)
    when {
        remainDays > 1L -> remainingTime = String.format(
            stringResource(R.string.upcoming_text_days),
            TimeUnit.MILLISECONDS.toDays(time - currentTimeStamp)
        )
        remainDays == 1L -> remainingTime =
            stringResource(R.string.upcoming_text_day)
        remainDays < 1L -> {
            when {
                remainHours > 1L -> remainingTime = String.format(
                    stringResource(R.string.upcoming_text_hours),
                    TimeUnit.MILLISECONDS.toHours(time - currentTimeStamp)
                )
                remainHours == 1L -> remainingTime =
                    stringResource(R.string.upcoming_text_hour)
                remainHours < 1L -> remainingTime = String.format(
                    stringResource(R.string.upcoming_text_minutes),
                    TimeUnit.MILLISECONDS.toMinutes(time - currentTimeStamp)
                )
            }
        }
    }
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
                    text = remainingTime,
                    style = MaterialTheme.typography.h5,
                    color = colorResource(id = R.color.black_111)
                )
                Text(
                    modifier = Modifier.align(Alignment.CenterEnd),
                    text = "Upcoming",
                    style = MaterialTheme.typography.body1,
                    color = colorResource(id = R.color.blue_8ff),
                )
            }
            RecordCardContent(record)
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