package com.yehorsk.todotest.todos.exceptions

import com.yehorsk.todotest.exceptions.Response
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ToDoExceptionHandler {

    @ExceptionHandler(ToDoNotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleNoSuchElement(e: ToDoNotFoundException): ResponseEntity<Response<Unit>> {
        val error = Response<Unit>(
            message = e.message ?: "TODO_NOT_FOUND",
            status = HttpStatus.NOT_FOUND.value()
        )
        return ResponseEntity(error, HttpStatus.NOT_FOUND)
    }

}