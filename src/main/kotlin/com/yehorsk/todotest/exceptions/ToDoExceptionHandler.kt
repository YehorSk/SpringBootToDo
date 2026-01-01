package com.yehorsk.todotest.exceptions

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
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

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleValidationErrors(e: MethodArgumentNotValidException): ResponseEntity<Response<Map<String, Any>>>{
        val errors = mutableMapOf<String, Any>()
        e.bindingResult.fieldErrors.forEach { error ->
            errors[error.field] = error.defaultMessage ?: "Validation Failed"
        }
        val error = Response<Map<String, Any>>(
            data = errors,
            message = "Validation error",
            status = HttpStatus.BAD_REQUEST.value()
        )
        return ResponseEntity(error, HttpStatus.BAD_REQUEST)
    }

}