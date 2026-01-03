package com.yehorsk.todotest

import com.yehorsk.todotest.repository.model.SubTaskEntity
import com.yehorsk.todotest.repository.model.ToDoEntity
import com.yehorsk.todotest.service.model.CreateToDoDto
import com.yehorsk.todotest.service.model.SubTaskDto
import com.yehorsk.todotest.service.model.ToDoDto

fun ToDoEntity.toToDoDto() = ToDoDto(
    id = this.id,
    name = this.name,
    description = this.description,
    subTasks = this.subTasks.map { it.toSubTaskDto() }.toSet()
)

fun ToDoDto.toToDoEntity() = ToDoEntity(
    id = this.id,
    name = this.name,
    description = this.description,
    subTasks = this.subTasks.map { it.toSubTaskEntity() }.toMutableSet()
)

fun CreateToDoDto.toToDoEntity() = ToDoEntity(
    name = this.name,
    description = this.description
)

fun SubTaskEntity.toSubTaskDto() = SubTaskDto(
    id = this.id,
    description = this.description,
    name = this.name,
    todoId = this.todo?.id
)

fun SubTaskDto.toSubTaskEntity() = SubTaskEntity(
    id = this.id,
    description = this.description,
    name = this.name,
)
