package com.yehorsk.todotest.todos.service.dtos.responses

import com.yehorsk.todotest.subtasks.service.dtos.responses.SubTaskDto
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class ToDoDto(
    val id: Long? = null,
    @field:NotBlank(message = "Name must not be blank")
    @field:Size(min = 5, message = "Name must be at least 5 characters")
    val name: String,
    @field:NotBlank(message = "Description must not be blank")
    @field:Size(min = 5, message = "Description must be at least 5 characters")
    val description: String,
    val subTasks: Set<SubTaskDto> = emptySet()
)