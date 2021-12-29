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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource

import androidx.compose.ui.text.font.FontWeight
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavController
import coil.annotation.ExperimentalCoilApi
import com.example.composeapp.R
import com.example.composeapp.data.database.model.Item

@ExperimentalCoilApi
@Composable
fun CompletedCard(navController: NavController, record: Item) {
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
                .wrapContentHeight()
        ) {
            ConstraintLayout(
                Modifier
                    .fillMaxWidth()
                    .padding(12.dp),

                ) {
                val guildLine = createGuidelineFromStart(0.75f)
                val (hint, status) = createRefs()

                Text(
                    modifier = Modifier
                        .constrainAs(hint) {
                            linkTo(parent.start, guildLine)
                            width = Dimension.fillToConstraints
                        },
                    text = stringResource(id = R.string.you_completed_appointment),
                    style = MaterialTheme.typography.h6,
                    color = colorResource(id = R.color.black_111)
                )

                Text(
                    modifier = Modifier
                        .constrainAs(status) {
                            end.linkTo(parent.end)
                            top.linkTo(parent.top)
                            bottom.linkTo(parent.bottom)
                            width = Dimension.preferredWrapContent
                        },
                    text = "Completed",
                    style = MaterialTheme.typography.body1,
                    color = colorResource(id = R.color.green_d93)
                )
            }
            RecordCardContent(record)
            ConstraintLayout(
                Modifier
                    .fillMaxWidth()
                    .height(IntrinsicSize.Min),
            ) {
                val (leftBtn, divider, rightBtn) = createRefs()
                Text(
                    modifier = Modifier
                        .padding(16.dp)
                        .constrainAs(leftBtn) {
                            start.linkTo(parent.start)
                            end.linkTo(divider.start)
                        },
                    text = "Give feedback",
                    color = colorResource(id = R.color.grey_d7d),
                    style = MaterialTheme.typography.h5,
                    fontWeight = FontWeight.W500
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
                    text = "Pending clinical notes",
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
