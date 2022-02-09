package com.universitydatabasemvvm.ui.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.universitydatabasemvvm.data.entity.Teacher

@Composable
fun ShowTeachers(vm: UniversityViewModel) {
    var teachers = vm.teachers

    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(bottom = 56.dp))
    {
        teachers.value.forEach {
            MyCardTeacher(teacher = it)
        }
    }
}

@Composable
fun MyCardTeacher(teacher: Teacher) {
    Card(elevation = 5.dp, modifier = Modifier
        .padding(5.dp)
        .fillMaxWidth()) {
        Column(modifier = Modifier.padding(5.dp)) {
            Text("${teacher.firstName} ${teacher.lastName}")
            Text("Teacher Id: ${teacher.teacherId}")
            Text("Major: ${teacher.majorName}")
        }
    }
}