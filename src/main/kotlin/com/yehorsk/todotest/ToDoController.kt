package com.yehorsk.todotest

import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
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

    @PostMapping
    fun saveToDo(@RequestBody toDoDto: ToDoDto): ToDoDto{
        return toDoService.saveToDo(toDoDto)
    }

    @PutMapping
    fun updateToDo(@RequestBody toDoDto: ToDoDto): ToDoDto{
        return toDoService.updateToDo(toDoDto)
    }

    @DeleteMapping
    fun deleteToDo(@RequestBody toDoDto: ToDoDto){
        toDoService.deleteToDo(toDoDto)
    }

}