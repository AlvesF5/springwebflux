package com.spring.webflux.webfluxapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@EnableMongoRepositories(basePackages = ["com.spring.webflux.webfluxapi"]
)
@SpringBootApplication
class WebfluxApiApplication

fun main(args: Array<String>) {
	runApplication<WebfluxApiApplication>(*args)
	println("Hello World Spring Webflux!")
}
