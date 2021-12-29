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
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import coil.annotation.ExperimentalCoilApi
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.example.composeapp.R
import com.example.composeapp.data.database.model.Item
import com.example.composeapp.utils.TeleDoctorHelper

@ExperimentalCoilApi
@Composable
fun RecordCardContent(record: Item) {
    Column(
        Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Divider(thickness = 1.dp)
        ConstraintLayout(
            modifier = Modifier
                .padding(start = 12.dp, end = 12.dp, top = 12.dp, bottom = 24.dp)
                .wrapContentHeight()
                .fillMaxWidth()

        ) {
            val (avatar, content, arrow) = createRefs()
            Image(
                modifier = Modifier
                    .width(60.dp)
                    .height(60.dp)
                    .constrainAs(avatar) {
                        start.linkTo(parent.start)
                    },
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
            Column(
                Modifier
//                    .fillMaxHeight()
                    .padding(start = 12.dp)
                    .constrainAs(content) {
                        linkTo(avatar.end, arrow.start)
                        width = Dimension.preferredWrapContent
                    }
            ) {

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
                        text = TeleDoctorHelper.dateFormatToLocalTime(record.start.toString()),
                        style = MaterialTheme.typography.h5,
                        color = colorResource(id = R.color.grey_d7d)
                    )
                }
            }

            Image(
                modifier = Modifier.constrainAs(arrow) {
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                },
                painter = painterResource(id = R.drawable.ic_grey_arrow),
                contentDescription = null
            )
        }
        Divider(thickness = 1.dp)
    }

}
