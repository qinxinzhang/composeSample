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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.annotation.ExperimentalCoilApi
import com.example.composeapp.R
import com.example.composeapp.data.database.model.Item
import com.example.composeapp.data.database.model.helper.RecordStatus

@ExperimentalCoilApi
@Composable
fun MissedCard(navController: NavController, record: Item) {
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
                    text = when (record.status) {
                        RecordStatus.SERVER_MISSED_BY_DOCTOR -> stringResource(id = R.string.missed_by_doctor_alert)
                        RecordStatus.SERVER_MISSED_BY_PATIENT -> stringResource(id = R.string.missed_by_you_alert)
                        else -> {
                            "NA"
                        }
                    },
                    style = MaterialTheme.typography.h5,
                    color = colorResource(id = R.color.black_111)
                )
                Text(
                    modifier = Modifier.align(Alignment.CenterEnd),
                    text = "Missed",
                    style = MaterialTheme.typography.body1,
                    color = colorResource(id = R.color.red_757),
                )
            }
            RecordCardContent(record)

        }
    }
}