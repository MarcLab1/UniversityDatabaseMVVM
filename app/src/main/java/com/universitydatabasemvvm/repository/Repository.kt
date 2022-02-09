package com.universitydatabasemvvm.repository

import com.universitydatabasemvvm.data.entity.Major
import com.universitydatabasemvvm.data.entity.Student
import com.universitydatabasemvvm.data.entity.Teacher
import com.universitydatabasemvvm.data.relation.MajorWithStudents
import com.universitydatabasemvvm.data.relation.TeacherWithMajor
import kotlinx.coroutines.flow.Flow

interface Repository {

    fun getStudents() : Flow<List<Student>>
    fun getTeachers() : Flow<List<Teacher>>
    fun getMajors() : Flow<List<Major>>

    suspend fun insertStudent(student: Student)
    suspend fun insertTeacher(teacher: Teacher)
    suspend fun insertMajor(major: Major)

    suspend fun deleteStudent(student: Student)
    suspend fun deleteTeacher(teacher: Teacher)
    suspend fun deleteMajor(major: Major)

    suspend fun updateStudent(student: Student)
    suspend fun updateTeacer(teacher: Teacher)
    suspend fun updateMajor(major: Major)

    fun getTeachersWithMajor(majorName: String) : Flow<List<TeacherWithMajor>>
    fun getStudentsWithMajor(majorName: String): Flow<List<MajorWithStudents>>

    fun getTeachersWithMajorCount(majorName: String): Flow<Int>
    fun getStudentsWithMajorCount(majorName: String) : Flow<Int>
}