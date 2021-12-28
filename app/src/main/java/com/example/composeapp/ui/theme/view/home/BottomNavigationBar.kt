package com.example.composeapp.ui.theme.view.home

import androidx.compose.foundation.Image
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.composeapp.HomeNavigationItem
import com.example.composeapp.R
import com.example.composeapp.TOKEN

@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        HomeNavigationItem.Home,
        HomeNavigationItem.Appointment,
        HomeNavigationItem.Shop,
        HomeNavigationItem.Profile
    )
    BottomNavigation(
        backgroundColor = colorResource(id = R.color.white),
        contentColor = Color.Blue
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEach { item ->
            BottomNavigationItem(
                icon = { Image(painterResource(id = item.icon), contentDescription = item.title) },
                label = { Text(text = item.title, style = MaterialTheme.typography.body1) },
                selectedContentColor = colorResource(id = R.color.blue_8ff),
                unselectedContentColor = colorResource(id = R.color.black_111),
                alwaysShowLabel = true,
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(
                        if (item.route == HomeNavigationItem.Appointment.route) {
                            HomeNavigationItem.Appointment.route + "/$TOKEN"
                        } else {
                            item.route
                        }

                    ) {
                        // Pop up to the start destination of the graph to
                        // avoid building up a large stack of destinations
                        // on the back stack as users select items
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        // Avoid multiple copies of the same destination when
                        // re-selecting the same item
                        launchSingleTop = true
                        // Restore state when reselecting a previously selected item
                        restoreState = true
                    }
                }
            )
        }
    }
}