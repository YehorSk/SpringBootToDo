package com.yehorsk.todotest.todos

import com.yehorsk.todotest.todos.service.ToDoService
import com.yehorsk.todotest.todos.service.dtos.requests.CreateToDoDto
import com.yehorsk.todotest.todos.service.dtos.responses.ToDoDto
import jakarta.validation.Valid
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
    fun loadToDos(): List<ToDoDto> {
        return toDoService.getAll()
    }

    @GetMapping("/{id}")
    fun getToDoById(@PathVariable id: Long): ToDoDto {
        return toDoService.getToDoById(id)
    }

    @PostMapping
    fun saveToDo(@Valid @RequestBody toDoDto: CreateToDoDto): ToDoDto {
        return toDoService.saveToDo(toDoDto)
    }

    @PutMapping("/{id}")
    fun updateToDo(@PathVariable id: Long, @Valid @RequestBody toDoDto: ToDoDto): ToDoDto {
        return toDoService.updateToDo(id, toDoDto)
    }

    @DeleteMapping("/{id}")
    fun deleteToDo(@PathVariable id: Long) {
        toDoService.deleteToDo(id)
    }

}