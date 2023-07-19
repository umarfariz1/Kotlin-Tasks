package com.example.blog.Service

import com.example.blog.Model.RequestModel
import com.example.blog.Model.toEntity
import com.example.blog.Model.toModel
import com.example.blog.Repository.Model.StudentEntity
import com.example.blog.Repository.StudentRepo
import org.springframework.stereotype.Service
import java.util.*
import kotlin.jvm.optionals.toList

@Service
data class StudentService(val studentRepo : StudentRepo) {

    fun create(requestModel: RequestModel):List<StudentEntity>{
       return listOf(studentRepo.save(requestModel.toModel().toEntity()))
    }

    fun getAll(): List<StudentEntity> {
      return  studentRepo.findAll().toList()
    }

    fun getById(studentId: Long): Optional<StudentEntity> {
       var student = studentRepo.findById(studentId)

        return student
    }
 fun deleteUser(studentId: Long): String {
     //Checking the Existance of the Id
    var status: Boolean = studentRepo.existsById(studentId)
     //If found will be deleted else return not found
     var result:String = if(status) {
             studentRepo.deleteById(studentId)
         return  "Student Id: $studentId has been deleted "
     }else return "No user with Id $studentId found"
 }

    fun updateUser(requestModel: RequestModel,studentId: Long):String{
    var userDetails = studentRepo.findById(studentId).orElse(null)
        val result : String = if(userDetails == null){
            return "No user with Id $studentId found"
        }else{
            var updatedDetails = userDetails.copy(
                    name=requestModel.name,
                    age=requestModel.age,


            )
            studentRepo.save(updatedDetails)
            return "User: ${requestModel.name} has been Updated Successfully"
        }
    }
}
