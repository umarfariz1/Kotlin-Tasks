package com.example.blog.Model

import com.example.blog.Repository.Model.StudentEntity

data class StudentModel(
        var name:String,
        var age:Int,
        var id:Long
)

fun StudentModel.toEntity() = StudentEntity(
        name = name,
        age = age,
        id = id

)