package com.bank.sbibank.core.DTO

import com.bank.sbibank.core.Model.UserModel
import org.jetbrains.annotations.NotNull

class RequestDto(

        val firstName:String,
        val middleName:String?,
        @NotNull
        val lastName:String,
        @NotNull
        val fathersName:String,
        val dob:String
)
fun RequestDto.toModel()=UserModel(
        firstName = firstName,
        middleName = middleName,
        lastName = lastName,
        dob = dob,
        fullName = " ",
        accountNumber = 0,
        id = 0,
        fathersName = fathersName
)