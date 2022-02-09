package com.universitydatabasemvvm.ui.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.universitydatabasemvvm.data.entity.Major


@Composable
fun ShowMajors(vm: UniversityViewModel)
{   var majors = vm.majors

    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(bottom = 56.dp))
    {
        majors.value.forEach{
            MyCardMajor(major = it)
        }
    }
}

@Composable
fun MyCardMajor(major: Major) {
    Card(elevation = 5.dp, modifier = Modifier
        .padding(5.dp)
        .fillMaxWidth()) {
        Column(modifier = Modifier.padding(5.dp)) {
            Text("${major.majorName}")
        }
    }
}