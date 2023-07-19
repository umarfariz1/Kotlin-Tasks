package com.example.blog.Repository.Model

import com.example.blog.Model.RespondModel
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.util.UUID

@Entity
data class StudentEntity(
       var name:String,
        var age:Int,
       @Id
       @GeneratedValue
       var id : Long =0
) {

}
fun StudentEntity.toRespond() = RespondModel(
        name = name,
        age = age
)