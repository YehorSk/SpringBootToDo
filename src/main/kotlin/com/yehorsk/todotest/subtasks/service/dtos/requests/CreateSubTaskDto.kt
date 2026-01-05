package com.yehorsk.todotest.subtasks.service.dtos.requests

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class CreateSubTaskDto(
    @field:NotBlank(message = "Name must not be blank")
    @field:Size(min = 5, message = "Name must be at least 5 characters")
    val name: String,
    val description: String = ""
)
