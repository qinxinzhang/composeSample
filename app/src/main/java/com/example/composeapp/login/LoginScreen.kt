package com.example.composeapp.login

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeapp.R

@Composable

fun LoginScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 12.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painterResource(id = R.drawable.login_mwelllogo), contentDescription = null,
            alignment = Alignment.Center
        )
        Spacer(modifier = Modifier.height(160.dp))
        Text(
            text = "Sign in",
            style = MaterialTheme.typography.h3,
            color = colorResource(id = R.color.white),
            textAlign = TextAlign.Center,
            modifier = Modifier
                .background(
                    colorResource(id = R.color.blue_d94),
                    shape = RoundedCornerShape(12.dp)
                )
                .padding(vertical = 16.dp)
                .fillMaxWidth()
                .height(IntrinsicSize.Max)
        )

        Spacer(modifier = Modifier.height(32.dp))
        OutlinedButton(
            modifier = Modifier
                .height(IntrinsicSize.Max)
                .fillMaxWidth(),
            onClick = { },
            border = BorderStroke(1.dp, colorResource(id = R.color.blue_d94)),
            shape = RoundedCornerShape(12.dp), // = 50% percent
            //or shape = CircleShape
            colors = ButtonDefaults.outlinedButtonColors(contentColor = colorResource(id = R.color.blue_d94))
        ) {
            Text(
                modifier = Modifier
                    .padding(vertical = 8.dp),
                text = "Register",
                style = MaterialTheme.typography.h3,
                textAlign = TextAlign.Center,
                color = colorResource(id = R.color.blue_d94),
            )
        }
    }
}

@Preview
@Composable
fun preview() {
    LoginScreen()
}