package com.example.composeapp.ui.theme.view.home.recordcard

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
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
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import coil.annotation.ExperimentalCoilApi
import com.example.composeapp.R
import com.example.composeapp.data.database.model.Item
import com.example.composeapp.utils.TeleDoctorHelper

@ExperimentalCoilApi
@Composable
fun HappeningCard(navController: NavController, record: Item) {
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
                    text = stringResource(id = R.string.happening_now),
                    style = MaterialTheme.typography.h5,
                    color = colorResource(id = R.color.black_111)
                )
                Text(
                    modifier = Modifier.align(Alignment.CenterEnd),
                    text = "Happening Now",
                    style = MaterialTheme.typography.body1,
                    color = colorResource(id = R.color.blue_8ff),
                )
            }
            RecordCardContent(record)
            ConstraintLayout(
                Modifier
                    .fillMaxWidth()
                    .height(IntrinsicSize.Max),
            ) {
                val (leftBtn, divider, rightBtn) = createRefs()
                Text(
                    modifier = Modifier
                        .padding(16.dp)
                        .constrainAs(leftBtn) {
                            start.linkTo(parent.start)
                            end.linkTo(divider.start)
                        },
                    text = "Reschedule",
                    color = colorResource(id = R.color.grey_d7d),
                    style = MaterialTheme.typography.h5,
                    fontWeight = FontWeight.W500,
                )
                Divider(
                    thickness = 1.dp, modifier = Modifier
                        .fillMaxHeight()
                        .width(1.dp)
                        .constrainAs(divider) {
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        }
                )
                Text(
                    text = "Cancel",
                    color = colorResource(id = R.color.grey_d7d),
                    style = MaterialTheme.typography.h5,
                    fontWeight = FontWeight.W500,
                    modifier = Modifier
                        .padding(16.dp)
                        .constrainAs(rightBtn) {
                            start.linkTo(divider.end)
                            end.linkTo(parent.end)
                        }
                )
            }

        }
    }
}