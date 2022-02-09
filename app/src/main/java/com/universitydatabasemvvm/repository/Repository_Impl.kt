package com.universitydatabasemvvm.repository

import com.universitydatabasemvvm.data.dao.MajorDao
import com.universitydatabasemvvm.data.dao.StudentDao
import com.universitydatabasemvvm.data.dao.TeacherDao
import com.universitydatabasemvvm.data.entity.Major
import com.universitydatabasemvvm.data.entity.Student
import com.universitydatabasemvvm.data.entity.Teacher
import com.universitydatabasemvvm.data.relation.MajorWithStudents
import com.universitydatabasemvvm.data.relation.TeacherWithMajor
import kotlinx.coroutines.flow.Flow

class Repository_Impl(
    private val studentDao: StudentDao,
    private val teacherDao: TeacherDao,
    private val majorDao: MajorDao
) : Repository {
    override fun getStudents(): Flow<List<Student>> = studentDao.getStudents()

    override fun getTeachers(): Flow<List<Teacher>> = teacherDao.getTeachers()

    override fun getMajors(): Flow<List<Major>> = majorDao.getMajors()

    override suspend fun insertStudent(student: Student) {
        studentDao.insertStudent(student)
    }

    override suspend fun insertTeacher(teacher: Teacher) {
        teacherDao.insertTeacher(teacher)
    }

    override suspend fun insertMajor(major: Major) {
        majorDao.insertMajor(major)
    }

    override suspend fun deleteStudent(student: Student) {
        studentDao.insertStudent(student)
    }

    override suspend fun deleteTeacher(teacher: Teacher) {
        teacherDao.deleteTeacher(teacher)
    }

    override suspend fun deleteMajor(major: Major) {
        majorDao.deleteMajor(major)
    }

    override suspend fun updateStudent(student: Student) {
        studentDao.insertStudent(student)
    }

    override suspend fun updateTeacer(teacher: Teacher) {
        teacherDao.updateTeacher(teacher)
    }

    override suspend fun updateMajor(major: Major) {
        majorDao.updateMajor(major)
    }

    override fun getTeachersWithMajor(majorName: String): Flow<List<TeacherWithMajor>> {
        return teacherDao.getTeachersWithMajor(majorName)
    }

    override fun getStudentsWithMajor(majorName: String): Flow<List<MajorWithStudents>> {
        return majorDao.getStudentsWithMajor(majorName)
    }

    override fun getTeachersWithMajorCount(majorName: String): Flow<Int> {
        return teacherDao.getTeachersWithMajorCount(majorName)
    }

    override fun getStudentsWithMajorCount(majorName: String): Flow<Int> {
        return majorDao.getStudentsWithMajorCount(majorName)
    }

}