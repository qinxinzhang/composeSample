package com.example.composeapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.composeapp.HomeNavigationItem
import com.example.composeapp.LOGIN_NAVIGATION_ID
import com.example.composeapp.home.HomeScreen
import com.example.composeapp.login.LoginScreen
import com.example.composeapp.profile.ProfileScreen
import com.example.composeapp.recordcard.RecordDetailScreen
import com.example.composeapp.recordcard.RecordListScreen
import com.example.composeapp.shop.ShopScreen
import com.google.accompanist.pager.ExperimentalPagerApi


@ExperimentalPagerApi
@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = LOGIN_NAVIGATION_ID
    ) {
        composable(LOGIN_NAVIGATION_ID) {
            LoginScreen()
        }

        composable(HomeNavigationItem.Home.route) {
            HomeScreen()
        }
        composable(HomeNavigationItem.Appointment.route) {
            RecordListScreen(navController)
        }
        composable(HomeNavigationItem.Shop.route) {
            ShopScreen()
        }
        composable(HomeNavigationItem.Profile.route) {
            ProfileScreen()
        }
        composable("recordDetail") {
            RecordDetailScreen()
        }
    }
}