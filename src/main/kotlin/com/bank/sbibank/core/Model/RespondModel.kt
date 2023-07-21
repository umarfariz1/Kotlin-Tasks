package com.bank.sbibank.core.Model

import com.bank.sbibank.core.DTO.ResponseDTO
import com.bank.sbibank.core.Repository.Model.UserEntity

class RespondModel(
        val id:Int,
        val fullName:String,
        val accountNumber:Long,
        val dob:String
)

fun RespondModel.toRespondDto()= ResponseDTO(
        id = id,
        fullName = fullName,
        accountNumber=accountNumber,
        dob = dob
)
