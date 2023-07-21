package com.bank.sbibank

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SbiBankApplication

fun main(args: Array<String>) {
	runApplication<SbiBankApplication>(*args)
}
