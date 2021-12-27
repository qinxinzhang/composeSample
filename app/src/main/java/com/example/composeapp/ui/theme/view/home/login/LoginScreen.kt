package com.example.composeapp.ui.theme.view.home.login

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.composeapp.HomeNavigationItem
import com.example.composeapp.R

@Composable
fun LoginScreen(navHostController: NavHostController) {
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
                .clickable {
                    navHostController.navigate(HomeNavigationItem.Appointment.route + "/eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRoVHlwZSI6InVzZXJzIiwiZW1haWwiOiJsZnRlc3RhY2MxMkBnbWFpbC5jb20iLCJpZCI6IjFmNGI3N2ExLWJiOWYtNDg5MS05OTg5LTg5NTc5ODI5MTIyNyIsImtleV9pZCI6Ijc5OTBjMGE2MzU4ODQ4MzI5ODAzNzhlZmU3OTNlNDFlIiwiZXBvY2giOjE2NDA1OTk5NzYsInBhcnRuZXJfbmFtZSI6ImFuZHJvaWQtYXBwIiwidHlwZSI6MCwiaWF0IjoxNjQwNTk5Mzc2LCJleHAiOjE2NDA2MDI5NzZ9.x1M2udftCnq566CxZaMra9wKDbo_NTrTFEgoXIXSCSg")
                }
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
