package com.example.blog.Controller

import com.example.blog.Model.RequestModel
import com.example.blog.Repository.Model.StudentEntity
import com.example.blog.Service.StudentService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/student")
data class StudentController(val studentService: StudentService) {
    @GetMapping
    fun getAllUser(): List<StudentEntity> {
        return studentService.getAll()
    }

    @GetMapping("/{id}")
    fun getUserById(@PathVariable(value = "id") studentId: Long): Optional<StudentEntity> {
        return studentService.getById(studentId)
    }

    @DeleteMapping("/delete/{id}")
    fun deleteUserById(@PathVariable(value = "id") studentId: Long):String {
       return studentService.deleteUser(studentId)
    }

    @PutMapping("/update/{studentId}")
    fun updateUserDetails(@RequestBody requestModel: RequestModel,@PathVariable("studentId") studentId: Long):String{
       return studentService.updateUser(requestModel,studentId)
    }

    @PostMapping
    fun createUser(@RequestBody requestModel: RequestModel): List<StudentEntity> {
        return studentService.create(requestModel)
    }
}