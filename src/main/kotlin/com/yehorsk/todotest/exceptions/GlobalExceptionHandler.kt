package com.yehorsk.todotest.exceptions

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleValidationErrors(e: MethodArgumentNotValidException): Response<Map<String, Any>>{
        val errors = mutableMapOf<String, Any>()
        e.bindingResult.fieldErrors.forEach { error ->
            errors[error.field] = error.defaultMessage ?: "Validation Failed"
        }
        return Response(
            data = errors,
            message = "Validation error",
            status = HttpStatus.BAD_REQUEST.value()
        )
    }

}