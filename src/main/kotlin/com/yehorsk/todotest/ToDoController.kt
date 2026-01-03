package com.yehorsk.todotest

import com.yehorsk.todotest.exceptions.Response
import com.yehorsk.todotest.service.ToDoService
import com.yehorsk.todotest.service.model.CreateToDoDto
import com.yehorsk.todotest.service.model.ToDoDto
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
    fun loadToDos(): Response<List<ToDoDto>> {
        val todos = toDoService.getAll()
        return Response(
            data = todos,
        )
    }

    @GetMapping("/{id}")
    fun getToDoById(@PathVariable id: Long): Response<ToDoDto> {
        val todo = toDoService.getToDoById(id)
        return Response(
            data = todo,
        )
    }

    @PostMapping
    fun saveToDo(@Valid @RequestBody toDoDto: CreateToDoDto): Response<ToDoDto> {
        val todo = toDoService.saveToDo(toDoDto)
        return Response(
            data = todo,
            status = 201
        )
    }

    @PutMapping("/{id}")
    fun updateToDo(@PathVariable id: Long, @Valid @RequestBody toDoDto: ToDoDto): Response<ToDoDto> {
        val todo = toDoService.updateToDo(id, toDoDto)
        return Response(
            data = todo,
            status = 200
        )
    }

    @DeleteMapping("/{id}")
    fun deleteToDo(@PathVariable id: Long): Response<Unit>{
        toDoService.deleteToDo(id)
        return Response(
            message = "Deleted Successfully"
        )
    }

}