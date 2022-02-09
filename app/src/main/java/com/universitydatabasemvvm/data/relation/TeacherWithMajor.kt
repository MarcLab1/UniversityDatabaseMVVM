package com.universitydatabasemvvm.data.relation

import androidx.room.Embedded
import androidx.room.Relation
import com.universitydatabasemvvm.data.entity.Major
import com.universitydatabasemvvm.data.entity.Teacher

// 1 to 1 mapping is not guaranteed, 1 major can have multiple teachers
// because as of now, the UI interface allows this insertion into the db
class TeacherWithMajor(

    @Embedded
    val teacher: Teacher,

    @Relation(parentColumn = "majorName", entityColumn = "majorName")
    val major: Major

)
