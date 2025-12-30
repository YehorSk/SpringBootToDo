package com.yehorsk.todotest

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