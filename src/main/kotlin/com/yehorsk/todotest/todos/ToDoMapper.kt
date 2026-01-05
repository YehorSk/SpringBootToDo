package com.yehorsk.todotest.todos

import com.yehorsk.todotest.subtasks.repository.entitities.SubTaskEntity
import com.yehorsk.todotest.todos.repository.entities.ToDoEntity
import com.yehorsk.todotest.subtasks.service.dtos.responses.SubTaskDto
import com.yehorsk.todotest.todos.service.dtos.requests.CreateToDoDto
import com.yehorsk.todotest.todos.service.dtos.responses.ToDoDto

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
