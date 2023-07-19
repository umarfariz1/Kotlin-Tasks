package com.example.blog.Model

data class RequestModel (
        var name:String,
        var age:Int
)

fun RequestModel.toModel()=StudentModel(
        name = name,
        age = age,
        id = 0
)



