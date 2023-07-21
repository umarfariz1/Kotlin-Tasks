package com.bank.sbibank.core.Repository

import com.bank.sbibank.core.Repository.Model.UserEntity
import org.springframework.data.repository.CrudRepository

interface SbiRepository:CrudRepository<UserEntity,Int> {
}