package com.siran.sportevent

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity


@SpringBootApplication
@EnableWebSecurity
class SportEventApplication

fun main(args: Array<String>) {
    runApplication<SportEventApplication>(*args)
}
