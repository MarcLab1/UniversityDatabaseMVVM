package com.universitydatabasemvvm.util

import android.graphics.drawable.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

object Constants {

    val navItems = listOf(
        navItem("Major", "major", Icons.Filled.Home),
        navItem("Teacher", "teacher", Icons.Filled.Add),
        navItem("Student", "student", Icons.Filled.AddCircle))
}

class navItem (
    val label: String,
    val route: String,
    val imageVector: ImageVector
)
