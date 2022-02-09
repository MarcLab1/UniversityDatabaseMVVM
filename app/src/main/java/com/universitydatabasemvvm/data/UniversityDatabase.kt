package com.universitydatabasemvvm.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.universitydatabasemvvm.data.dao.MajorDao
import com.universitydatabasemvvm.data.dao.StudentDao
import com.universitydatabasemvvm.data.dao.TeacherDao
import com.universitydatabasemvvm.data.entity.Major
import com.universitydatabasemvvm.data.entity.Student
import com.universitydatabasemvvm.data.entity.Teacher
import com.universitydatabasemvvm.util.Converters

@TypeConverters(Converters::class)
@Database(entities = [Student::class, Teacher::class, Major::class], version = 1)
abstract class UniversityDatabase : RoomDatabase() {

    abstract fun studentDao(): StudentDao
    abstract fun teacherDao(): TeacherDao
    abstract fun majorDao(): MajorDao

}