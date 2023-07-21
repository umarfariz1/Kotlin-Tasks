package com.bank.sbibank.core.Repository.Model

import com.bank.sbibank.core.Model.RespondModel
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class UserEntity (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id:Int,
        val fullName:String,
        val accountNumber:Long,
        val dob:String
)
fun UserEntity.toRespondModel()=RespondModel(
        id = id,
        fullName = fullName,
        accountNumber=accountNumber,
        dob = dob
)
