package com.yehorsk.todotest

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ToDoTestApplication

fun main(args: Array<String>) {
    runApplication<ToDoTestApplication>(*args)
}
