package com.universitydatabasemvvm.data.dao

import androidx.room.*
import com.universitydatabasemvvm.data.relation.MajorWithStudents
import com.universitydatabasemvvm.data.entity.Major
import kotlinx.coroutines.flow.Flow

@Dao
interface MajorDao {

    @Query("SELECT * FROM major")
    fun getMajors() : Flow<List<Major>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMajor(major: Major)

    @Delete
    suspend fun deleteMajor(major: Major)

    @Update
    suspend fun updateMajor(major: Major)

    //@Transaction
    //@Query("SELECT * FROM major WHERE teacherId =:teacherId")
    //fun getMajorWithTeacher(teacherId: Int): Flow<List<MajorWithTeacher>>

    @Transaction
    @Query("SELECT * FROM major WHERE majorName =:majorName")
    fun getStudentsWithMajor(majorName: String): Flow<List<MajorWithStudents>>

    @Transaction
    @Query("SELECT COUNT(*) FROM major WHERE majorName =:majorName")
    fun getStudentsWithMajorCount(majorName: String): Flow<Int>

}