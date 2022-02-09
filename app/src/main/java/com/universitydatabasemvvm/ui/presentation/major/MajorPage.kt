package com.universitydatabasemvvm.ui.presentation.major

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.universitydatabasemvvm.ui.presentation.*

@Composable
fun MajorPage(vm: UniversityViewModel) {
    LazyColumn()
    {
        item()
        {
            AddMajor(vm = vm)
        }
        item()
        {
            ShowMajors(vm = vm)
        }
    }
}