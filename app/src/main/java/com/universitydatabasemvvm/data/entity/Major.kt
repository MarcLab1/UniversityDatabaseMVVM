package com.universitydatabasemvvm.data.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey

/*
@Entity(
    foreignKeys = [ForeignKey(
        entity = Teacher::class,
        parentColumns = arrayOf("teacherId"),
        childColumns = arrayOf("teacherId"),
        onDelete = ForeignKey.CASCADE
    )]
)
 */
@Entity
data class Major(

    @PrimaryKey(autoGenerate = false)  val majorName: String,
    //val teacherId: Int,
    //val majorId: Int =0
)
