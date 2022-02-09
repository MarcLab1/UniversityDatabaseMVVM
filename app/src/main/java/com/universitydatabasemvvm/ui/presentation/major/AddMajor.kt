package com.universitydatabasemvvm.ui.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.universitydatabasemvvm.data.entity.Major

@Composable
fun AddMajor(vm: UniversityViewModel) {
    var name = remember { mutableStateOf("") }

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
                value = name.value,
                onValueChange = { name.value = it },
                modifier = Modifier.padding(bottom = 5.dp),
                placeholder = { Text("name") }
            )

            Button(onClick = {
                vm.insertMajor(
                    Major(
                        name.value
                    )
                )
                name.value = ""
            }) {
                Text("Add Major")
            }
        }
    }
}