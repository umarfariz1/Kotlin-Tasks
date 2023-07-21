package com.bank.sbibank.core.Service

import com.bank.sbibank.core.Exception.MyCustomException
import com.bank.sbibank.core.Model.RespondModel
import com.bank.sbibank.core.Model.UserModel
import com.bank.sbibank.core.Model.toEntity
import com.bank.sbibank.core.Repository.Model.toRespondModel
import com.bank.sbibank.core.Repository.SbiRepository
import org.springframework.stereotype.Service
import kotlin.jvm.optionals.toList

@Service
data class SbiService(private val repository: SbiRepository) {
    //Create User ID
    fun createUser(userModel: UserModel): RespondModel {
        return repository.save(userModel.toEntity()).toRespondModel()
    }

    //Get All User
    fun getAllUser(): List<RespondModel> {
        return repository.findAll().map { it.toRespondModel() }
    }
    //Get User details by ID
    fun getAllUserById(userId: Int): List<RespondModel> {

        return repository.findById(userId).toList().map { it.toRespondModel() }
    }
    // Update User Details by ID
    fun updateUserDetails(userId: Int, userModel: UserModel): RespondModel {
        val userOldData = repository.findById(userId).orElse(null)
        if (userOldData != null) {

            val updatedUserDetails = userOldData.copy(
                    fullName = userModel.fullName(),
                    dob = userModel.dob
            )
            return repository.save(updatedUserDetails).toRespondModel()
        } else {
            throw MyCustomException ("Invalid User Id: $userId ")

        }
    }

    //Delete user details
    fun deleteUserById(userId: Int):String{
       val userDetailAvailabilityConfirmation =  repository.existsById(userId)
         return if (userDetailAvailabilityConfirmation){
            repository.deleteById(userId)
             "User Id: $userId has been deleted successfully "
        }else {
             "Invalid user ID:$userId "
        }
    }
}