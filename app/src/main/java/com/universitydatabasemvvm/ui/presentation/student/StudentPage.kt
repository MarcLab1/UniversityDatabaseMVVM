package com.universitydatabasemvvm.ui.presentation

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun StudentPage(vm: UniversityViewModel) {
    LazyColumn()
    {
        item()
        {
            AddStudent(vm = vm)
        }
        item()
        {
            ShowStudents(vm = vm)
        }
    }
}