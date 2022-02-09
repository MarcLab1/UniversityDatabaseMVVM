package com.universitydatabasemvvm.di

import android.app.Application
import androidx.room.Room
import com.universitydatabasemvvm.data.dao.MajorDao
import com.universitydatabasemvvm.data.dao.StudentDao
import com.universitydatabasemvvm.data.dao.TeacherDao
import com.universitydatabasemvvm.data.UniversityDatabase
import com.universitydatabasemvvm.repository.Repository
import com.universitydatabasemvvm.repository.Repository_Impl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideString(): String = "just for testing"

    @Singleton
    @Provides
    fun provideUniversityDatabase(application: Application): UniversityDatabase {
        return Room.databaseBuilder(application, UniversityDatabase::class.java, "university_db")
            .fallbackToDestructiveMigration().build()
    }

    @Singleton
    @Provides
    fun provideStudentDao(db: UniversityDatabase): StudentDao = db.studentDao()

    @Singleton
    @Provides
    fun provideTeacherDao(db: UniversityDatabase): TeacherDao = db.teacherDao()

    @Singleton
    @Provides
    fun provideCourseDao(db: UniversityDatabase): MajorDao = db.majorDao()

    @Singleton
    @Provides
    fun provideRepository(
       db: UniversityDatabase
    ): Repository {
        return Repository_Impl(db.studentDao(), db.teacherDao(), db.majorDao())
    }
}