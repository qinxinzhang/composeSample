package com.example.composeapp

sealed class HomeNavigationItem(var route: String, var icon: Int, var title: String) {
    object Home : HomeNavigationItem(HOME_NAVIGATION_ID, R.drawable.ic_foot_home_1, "Home")
    object Appointment :
        HomeNavigationItem(
            APPOINTMENT_NAVIGATION_ID,
            R.drawable.ic_foot_appointment_1,
            "Appointment"
        )

    object Shop : HomeNavigationItem(SHOP_NAVIGATION_ID, R.drawable.ic_foot_shop_1, "Shop")
    object Profile :
        HomeNavigationItem(PROFILE_NAVIGATION_ID, R.drawable.ic_foot_profile_1, "Profile")
}
