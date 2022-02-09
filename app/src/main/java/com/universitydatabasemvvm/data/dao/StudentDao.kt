package com.universitydatabasemvvm.data.dao

import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import com.universitydatabasemvvm.data.entity.Student
import kotlinx.coroutines.flow.Flow

@Dao
interface StudentDao {

    @Query("SELECT * FROM student")
    fun getStudents() : Flow<List<Student>>

    @Insert(onConflict = REPLACE)
    suspend fun insertStudent(student: Student)

    @Delete
    suspend fun deleteStudent(student: Student)

    @Update
    suspend fun updateStudent(student: Student)
}