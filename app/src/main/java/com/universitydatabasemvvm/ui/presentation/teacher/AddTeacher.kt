package com.universitydatabasemvvm.ui.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.universitydatabasemvvm.data.entity.Teacher

@Composable
fun AddTeacher(vm: UniversityViewModel) {
    var fname = remember { mutableStateOf("") }
    var lname = remember { mutableStateOf("") }

    // var majors = vm.majors!!.collectAsState(initial = listOf())
    //both options work - collectasstate in the composable and collect in the vm

    var majors = vm.majors
    var selectedMajor by remember {
        mutableStateOf(majors.value.getOrNull(0))
    }

    Card(
        elevation = 5.dp, modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        )
        {
            TextField(
                value = fname.value,
                onValueChange = { fname.value = it },
                modifier = Modifier.padding(bottom = 5.dp),
                placeholder = { Text("First Name") }
            )
            TextField(
                value = lname.value,
                onValueChange = { lname.value = it },
                placeholder = { Text("Last Name") }
            )

            selectedMajor?.let { MajorSelector(majors.value, it, { selectedMajor = it }) }

            Button(onClick = {
                selectedMajor?.let {
                    Teacher(
                        fname.value,
                        lname.value,
                        it.majorName
                    )
                }?.let {
                    vm.insertTeacher(
                        it
                    )
                }
                fname.value = ""
                lname.value = ""
            }) {
                Text("Add Teacher")
            }
        }
    }
}