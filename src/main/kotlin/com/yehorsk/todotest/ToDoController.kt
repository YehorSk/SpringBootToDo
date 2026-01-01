package com.yehorsk.todotest

import com.yehorsk.todotest.service.ToDoService
import com.yehorsk.todotest.service.model.ToDoDto
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/todos")
class ToDoController(
    private val toDoService: ToDoService
) {

    @GetMapping
    fun loadToDos(): ResponseEntity<List<ToDoDto>> {
        val todos = toDoService.getAll()
        return ResponseEntity
            .ok()
            .body(todos)
    }

    @GetMapping("/{id}")
    fun getToDoById(@PathVariable id: Long): ResponseEntity<ToDoDto> {
        val todo = toDoService.getToDoById(id)
        return ResponseEntity.ok(todo)
    }

    @PostMapping
    fun saveToDo(@Valid @RequestBody toDoDto: ToDoDto): ResponseEntity<ToDoDto> {
        val todo = toDoService.saveToDo(toDoDto)
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(todo)
    }

    @PutMapping("/{id}")
    fun updateToDo(@PathVariable id: Long, @Valid @RequestBody toDoDto: ToDoDto): ResponseEntity<ToDoDto> {
        val todo = toDoService.updateToDo(id, toDoDto)
        return ResponseEntity.ok(todo)
    }

    @DeleteMapping("/{id}")
    fun deleteToDo(@PathVariable id: Long): ResponseEntity<Unit>{
        toDoService.deleteToDo(id)
        return ResponseEntity
            .noContent()
            .build()
    }

}