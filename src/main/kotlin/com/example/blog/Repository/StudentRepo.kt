package com.example.blog.Repository

import com.example.blog.Repository.Model.StudentEntity
import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface StudentRepo:CrudRepository <StudentEntity,Long>{

}