package com.universitydatabasemvvm.ui.presentation

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.universitydatabasemvvm.util.Constants

@Composable
fun BottomNavigationBar(navController: NavController) {

    BottomNavigation() {

        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        Constants.navItems.forEach { item ->

            BottomNavigationItem(
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(Constants.navItems.get(0).route)
                        launchSingleTop = true
                    }
                },
                label = {
                    Text(text = item.label)
                },
                alwaysShowLabel = true,
                icon = {Icon(imageVector = item.imageVector, contentDescription = item.label)},
            )
        }
    }
}