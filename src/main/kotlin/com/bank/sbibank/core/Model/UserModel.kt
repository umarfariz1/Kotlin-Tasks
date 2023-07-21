package com.bank.sbibank.core.Model

import com.bank.sbibank.core.Repository.Model.UserEntity

data class UserModel(
        var firstName: String,
        val middleName: String?,
        var lastName: String,
        val id: Int,
        val fullName: String,
        val accountNumber: Long,
        var fathersName: String,
        val dob: String
)
{

    fun fullName():String{
        val initialOfUser: String = fathersName[0].toString()
        return if (middleName == null) "$firstName $lastName.$initialOfUser" else "$firstName $middleName $lastName.$initialOfUser"
    }

    fun generateAccountNumber():Long{
    return (12300000001..12300000999).random()
    }

}



fun UserModel.toEntity() = UserEntity(
        id = 0,
        accountNumber = generateAccountNumber(),
        fullName = fullName(),
        dob = dob
)