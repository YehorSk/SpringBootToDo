package com.yehorsk.todotest.exceptions

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ToDoExceptionHandler {

    @ExceptionHandler(NoSuchElementException::class)
    fun handleNoSuchElement(e: NoSuchElementException): ResponseEntity<String> {
        return ResponseEntity
            .badRequest()
            .body("ToDo doesn't exist")
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleValidationErrors(e: MethodArgumentNotValidException): ResponseEntity<Map<String, Any>>{
        val errors = mutableMapOf<String, Any>()
        e.bindingResult.fieldErrors.forEach { error ->
            errors[error.field] = error.defaultMessage ?: "Validation Failed"
        }
        return ResponseEntity
            .badRequest()
            .body(errors)
    }

}