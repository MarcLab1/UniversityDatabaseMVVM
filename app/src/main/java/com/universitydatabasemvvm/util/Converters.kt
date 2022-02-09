package com.universitydatabasemvvm.util

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.universitydatabasemvvm.data.entity.Student

class Converters {

    @TypeConverter
    fun listToJson(value: List<Student>?) = Gson().toJson(value)

    @TypeConverter
    fun jsonToList(value: String) = Gson().fromJson(value, Array<Student>::class.java).toList()
}