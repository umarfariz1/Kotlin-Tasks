package com.bank.sbibank.core.Exception

class MyCustomException (private val errorMessage : String): Exception(errorMessage) {
}