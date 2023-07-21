package com.bank.sbibank.core.Controller

import com.bank.sbibank.core.DTO.RequestDto
import com.bank.sbibank.core.DTO.ResponseDTO
import com.bank.sbibank.core.DTO.toModel
import com.bank.sbibank.core.Model.RespondModel
import com.bank.sbibank.core.Model.toRespondDto
import com.bank.sbibank.core.Service.SbiService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/sbi")
data class SbiController(private val sbiService: SbiService) {
    @PostMapping
    fun createNewUser(@RequestBody requestDto : RequestDto):ResponseDTO {
       return sbiService.createUser(requestDto.toModel()).toRespondDto()
    }
    @GetMapping
    fun getAllUser():List<ResponseDTO>{
        return sbiService.getAllUser().map { it.toRespondDto() }
    }
    @GetMapping("{id}")
    fun getUserById(@PathVariable(value = "id")userId:Int):List<ResponseDTO> {
        return sbiService.getAllUserById(userId).map { it.toRespondDto() }
    }
    @PutMapping("{id}")
    fun updateUserDetails(@PathVariable(value = "id")userId:Int,@RequestBody requestDto : RequestDto):ResponseDTO{
        return sbiService.updateUserDetails(userId,requestDto.toModel()).toRespondDto()
    }

    @DeleteMapping("{id}")
    fun deleteUserDetails(@PathVariable(value = "id")userId:Int):String{
        return sbiService.deleteUserById(userId)
    }
}