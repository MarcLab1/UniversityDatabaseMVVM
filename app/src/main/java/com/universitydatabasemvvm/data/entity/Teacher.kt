package com.universitydatabasemvvm.data.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    foreignKeys = [ForeignKey(
        entity = Major::class,
        parentColumns = arrayOf("majorName"),
        childColumns = arrayOf("majorName"),
        onDelete = ForeignKey.CASCADE
    )]
)
data class Teacher(

    val firstName : String,
    val lastName : String,
    val majorName : String,
    @PrimaryKey(autoGenerate = true) val teacherId : Int =0,

)
