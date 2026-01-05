package com.yehorsk.todotest.subtasks.exceptions

import com.yehorsk.todotest.exceptions.Response
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class SubTaskExceptionHandler {

    @ExceptionHandler(SubTaskNotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleNoSuchElement(e: SubTaskNotFoundException): Response<Unit>{
        return Response<Unit>(
            message = e.message ?: "SUBTASK_NOT_FOUND",
            status = HttpStatus.NOT_FOUND.value()
        )
    }

}