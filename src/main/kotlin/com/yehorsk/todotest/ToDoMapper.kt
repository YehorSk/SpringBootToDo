package com.yehorsk.todotest

import com.yehorsk.todotest.repository.model.ToDoEntity
import com.yehorsk.todotest.service.model.ToDoDto

fun ToDoEntity.toToDoDto() = ToDoDto(
    id = this.id,
    name = this.name,
    description = this.description
)

fun ToDoDto.toToDoEntity() = ToDoEntity(
    id = this.id,
    name = this.name,
    description = this.description
)