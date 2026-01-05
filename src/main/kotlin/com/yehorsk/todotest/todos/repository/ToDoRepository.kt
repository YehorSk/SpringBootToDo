package com.yehorsk.todotest.todos.repository

import com.yehorsk.todotest.todos.repository.entities.ToDoEntity
import org.springframework.data.jpa.repository.JpaRepository

interface ToDoRepository: JpaRepository<ToDoEntity, Long> {

}