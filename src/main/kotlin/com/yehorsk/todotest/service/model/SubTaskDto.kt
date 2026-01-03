package com.yehorsk.todotest.service.model

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class SubTaskDto(
    val id: Long? = null,
    @field:NotBlank(message = "Name must not be blank")
    @field:Size(min = 5, message = "Name must be at least 5 characters")
    val name: String,
    @field:NotBlank(message = "Description must not be blank")
    @field:Size(min = 5, message = "Description must be at least 5 characters")
    val description: String,
    var todoId: Long? = null
)

data class CreateSubTaskDto(
    @field:NotBlank(message = "Name must not be blank")
    val name: String,
    val description: String = ""
)