package com.universitydatabasemvvm.ui.presentation

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun ScaffoldPage() {
    var nav = rememberNavController()
    var vm: UniversityViewModel = viewModel()

    Scaffold(
        bottomBar = { BottomNavigationBar(nav) },
        content = { Navigation(nav as NavHostController, vm) })
}