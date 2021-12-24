package com.example.composeapp

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.composeapp.home.BottomNavigationBar
import com.example.composeapp.navigation.NavigationComponent
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalPagerApi
@Composable
fun MainScreen(navHostController: NavHostController) {


    Scaffold(
        bottomBar = { BottomNavigationBar(navHostController) }
    ) { innerPadding ->
        Box(
            modifier = Modifier.padding(
                PaddingValues(
                    0.dp,
                    0.dp,
                    0.dp,
                    innerPadding.calculateBottomPadding()
                )
            )
        ) {
            NavigationComponent(navHostController)
        }
    }
}
