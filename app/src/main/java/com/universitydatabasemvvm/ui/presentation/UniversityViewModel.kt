package com.universitydatabasemvvm.ui.presentation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.universitydatabasemvvm.data.entity.Major
import com.universitydatabasemvvm.data.entity.Student
import com.universitydatabasemvvm.data.entity.Teacher
import com.universitydatabasemvvm.data.relation.MajorWithStudents
import com.universitydatabasemvvm.data.relation.TeacherWithMajor
import com.universitydatabasemvvm.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UniversityViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    //var students: Flow<List<Student>>? = null
    //var teachers: Flow<List<Teacher>>? = null
    //var majors: Flow<List<Major>>? = null

    var majors: MutableState<List<Major>> = mutableStateOf(listOf())
    var teachers: MutableState<List<Teacher>> = mutableStateOf(listOf())
    var students: MutableState<List<Student>> = mutableStateOf(listOf())
    var teachersWithMajor: MutableState<List<TeacherWithMajor>> = mutableStateOf(listOf())
    var studentsWithMajor: MutableState<List<MajorWithStudents>> = mutableStateOf(listOf())

    init {

        viewModelScope.launch {
            repository.getMajors().collect {
                majors.value = it
            }
        }

        viewModelScope.launch {
            repository.getTeachers().collect {
                teachers.value = it
            }
        }

        viewModelScope.launch {
            repository.getStudents().collect {
                students.value = it
            }
        }
    }

    fun insertStudent(student: Student) {
        viewModelScope.launch {
            repository.insertStudent(student)
        }
    }

    fun insertTeacher(teacher: Teacher) {
        viewModelScope.launch {
            repository.insertTeacher(teacher)
        }
    }

    fun insertMajor(major: Major) {
        viewModelScope.launch {
            repository.insertMajor(major)
        }
    }

    fun getTeachersWithMajor(majorName: String) {
        viewModelScope.launch {
            repository.getTeachersWithMajor(majorName).collect {
                teachersWithMajor.value = it
            }
        }
    }

    fun getStudentsWithMajor(majorName: String) {
        viewModelScope.launch {
            repository.getStudentsWithMajor(majorName).collect {
                studentsWithMajor.value = it
            }
        }
    }


}