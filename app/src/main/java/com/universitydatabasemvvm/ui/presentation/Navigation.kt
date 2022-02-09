package com.universitydatabasemvvm.ui.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.universitydatabasemvvm.ui.presentation.major.MajorPage
import com.universitydatabasemvvm.ui.presentation.teacher.TeacherPage
import com.universitydatabasemvvm.util.Constants

@Composable
fun Navigation(nav: NavHostController, vm: UniversityViewModel)
{
    NavHost(navController = nav, startDestination = (Constants.navItems.get(0).route))
    {
        composable(Constants.navItems.get(0).route)
        {
            MajorPage(vm = vm)
        }
        composable(Constants.navItems.get(1).route)
        {
            TeacherPage(vm = vm)
        }
        composable(Constants.navItems.get(2).route)
        {
            StudentPage( vm = vm)
        }
    }
}