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
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavController
import coil.annotation.ExperimentalCoilApi
import com.example.composeapp.R
import com.example.composeapp.data.database.model.Item
import com.example.composeapp.data.database.model.helper.RecordStatus

@ExperimentalCoilApi
@Composable
fun CancelledCard(navController: NavController, record: Item) {
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
                            linkTo(parent.start, guildLine, bias = 0f)
                            width = Dimension.preferredWrapContent
                        },
                    text = when (record.status) {
                        RecordStatus.SERVER_CANCELLED_BY_DOCTOR -> stringResource(id = R.string.cancelled_by_doctor_hint)
                        RecordStatus.SERVER_CANCELLED_BY_PATIENT -> stringResource(id = R.string.cancelled_by_patient_hint)
                        else -> {
                            "NA"
                        }
                    },
                    style = MaterialTheme.typography.h6,
                    color = colorResource(id = R.color.black_111)
                )
                Text(
                    modifier = Modifier
                        .constrainAs(status) {
                            end.linkTo(parent.end)
                            linkTo(parent.top,parent.bottom)
                            width = Dimension.fillToConstraints
                        },
                    text = "Cancelled",
                    style = MaterialTheme.typography.body1,
                    color = colorResource(id = R.color.grey_4bf)
                )
            }
            RecordCardContent(record)

        }
    }
}