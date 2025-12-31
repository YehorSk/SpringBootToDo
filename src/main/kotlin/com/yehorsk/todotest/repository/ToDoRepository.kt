package com.yehorsk.todotest.repository

import com.yehorsk.todotest.repository.model.ToDoEntity
import org.springframework.data.repository.CrudRepository

interface ToDoRepository: CrudRepository<ToDoEntity, Long> {

}