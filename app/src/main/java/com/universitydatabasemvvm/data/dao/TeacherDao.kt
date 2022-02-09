package com.universitydatabasemvvm.data.dao

import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import com.universitydatabasemvvm.data.relation.TeacherWithMajor
import com.universitydatabasemvvm.data.entity.Teacher
import kotlinx.coroutines.flow.Flow

@Dao
interface TeacherDao {

    @Query("SELECT * FROM teacher")
    fun getTeachers() : Flow<List<Teacher>>

    @Insert(onConflict = REPLACE)
    suspend fun insertTeacher(teacher: Teacher)

    @Delete
    suspend fun deleteTeacher(teacher: Teacher)

    @Update
    suspend fun updateTeacher(teacher: Teacher)

    @Transaction  //resolves multithreading issues
    @Query("SELECT * FROM teacher WHERE majorName =:majorName")
    fun getTeachersWithMajor(majorName: String): Flow<List<TeacherWithMajor>>

    @Transaction
    @Query("SELECT COUNT(*) FROM teacher WHERE majorName =:majorName")
    fun getTeachersWithMajorCount(majorName: String): Flow<Int>
}