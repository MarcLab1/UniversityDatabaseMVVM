package com.universitydatabasemvvm.ui.presentation.teacher

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.universitydatabasemvvm.ui.presentation.AddTeacher
import com.universitydatabasemvvm.ui.presentation.UniversityViewModel
import com.universitydatabasemvvm.ui.presentation.ShowTeachers

@Composable
fun TeacherPage(vm: UniversityViewModel)
{
    LazyColumn()
    {
        item()
        {
            AddTeacher(vm = vm)
        }
        item()
        {
            ShowTeachers(vm = vm)
        }
    }
}