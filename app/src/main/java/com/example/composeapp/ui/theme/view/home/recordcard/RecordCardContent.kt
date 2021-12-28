package com.example.composeapp.ui.theme.view.home.recordcard

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.example.composeapp.R
import com.example.composeapp.data.database.model.Item

@ExperimentalCoilApi
@Composable
fun RecordCardContent(record: Item) {
    Column() {
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
                    painter = rememberImagePainter(
                        data = record.practitioner?.avatar,
                        onExecute = ImagePainter.ExecuteCallback { _, _ -> true },
                        builder = {
                            crossfade(true)
                            placeholder(R.drawable.default_avatar)
                            transformations(CircleCropTransformation())
                        }
                    ),
                    contentDescription = null
                )
                Column(Modifier.padding(start = 12.dp)) {

                    Text(
                        text = record.practitioner?.name ?: "",
                        style = MaterialTheme.typography.h3
                    )

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_hospital),
                            contentDescription = null
                        )
                        Text(
                            modifier = Modifier.padding(start = 4.dp),
                            text = record.practitioner?.hospitalName ?: "",
                            style = MaterialTheme.typography.h5,
                            color = colorResource(id = R.color.grey_d7d)
                        )
                    }
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_time_clock),
                            contentDescription = null
                        )
                        Text(
                            modifier = Modifier.padding(start = 4.dp),
                            text = "Feb 10, 2021 10:00 am",
                            style = MaterialTheme.typography.h5,
                            color = colorResource(id = R.color.grey_d7d)
                        )
                    }
                }
            }

            Image(
                modifier = Modifier.align(Alignment.CenterEnd),
                painter = painterResource(id = R.drawable.ic_grey_arrow),
                contentDescription = null
            )
        }
        Divider(thickness = 1.dp)
    }

}
