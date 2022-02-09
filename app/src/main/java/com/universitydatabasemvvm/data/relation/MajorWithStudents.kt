package com.universitydatabasemvvm.data.relation

import androidx.room.Embedded
import androidx.room.Relation
import com.universitydatabasemvvm.data.entity.Major
import com.universitydatabasemvvm.data.entity.Student

//one to many relationship
data class MajorWithStudents(
    @Embedded
    val major : Major,

    @Relation(parentColumn = "majorName", entityColumn = "majorName")
    val students: List<Student>
)
