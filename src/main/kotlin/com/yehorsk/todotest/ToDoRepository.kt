package com.yehorsk.todotest

import org.springframework.data.repository.CrudRepository

interface ToDoRepository: CrudRepository<ToDoEntity, Long> {

    fun findByName(name: String): List<ToDoEntity>

}