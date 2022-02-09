package com.universitydatabasemvvm.ui.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.universitydatabasemvvm.data.entity.Major
import com.universitydatabasemvvm.ui.theme.Purple200


@Composable
fun MajorSelector(majors: List<Major>, selectedMajor: Major, onClick: (newSelectedMajor: Major) -> Unit) {

    var expanded by remember { mutableStateOf(false) }

    Row(Modifier.padding(20.dp))
    {
        Text("Major:   ")
        selectedMajor?.let { Text(it.majorName) }
        Box {
            Icon(
                imageVector = Icons.Filled.ArrowDropDown,
                contentDescription = "",
                tint = Purple200,
                modifier = Modifier
                    .clickable {
                        expanded = true
                    }
            )
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
            ) {
                majors.forEach { major ->
                    DropdownMenuItem( onClick = { expanded = false
                        onClick(major)})
                    {
                        Text(text = major.majorName)
                    }
                }
            }
        }
    }
}