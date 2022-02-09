package com.universitydatabasemvvm.ui.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.universitydatabasemvvm.data.entity.Student

@Composable
fun ShowStudents(vm: UniversityViewModel)
{   var students = vm.students

    Column(modifier = Modifier.fillMaxWidth().padding(bottom = 56.dp))
    {
      students.value.forEach{
          MyCardStudent(student = it)
      }
    }
}


@Composable
fun MyCardStudent(student: Student) {
    Card(elevation = 5.dp, modifier = Modifier
        .padding(5.dp)
        .fillMaxWidth()) {
        Column(modifier = Modifier.padding(5.dp)) {
            Text("${student.firstName} ${student.lastName}")
            Text("Student Id: ${student.studentId}")
            Text("Major: ${student.majorName}")
        }

    }
}