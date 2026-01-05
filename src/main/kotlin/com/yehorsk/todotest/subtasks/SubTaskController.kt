package com.yehorsk.todotest.subtasks

import com.yehorsk.todotest.subtasks.service.SubTaskService
import com.yehorsk.todotest.todos.service.ToDoService
import com.yehorsk.todotest.subtasks.service.dtos.requests.CreateSubTaskDto
import com.yehorsk.todotest.subtasks.service.dtos.requests.UpdateSubTaskDto
import com.yehorsk.todotest.subtasks.service.dtos.responses.SubTaskDto
import com.yehorsk.todotest.todos.toToDoEntity
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
@RequestMapping("/subtask")
class SubTaskController(
    private val subTaskService: SubTaskService,
    private val toDoService: ToDoService
) {

    @GetMapping("/{id}")
    fun getSubTask(@PathVariable id: Long): SubTaskDto {
        return subTaskService.getById(id)
    }

    @PostMapping("/{id}")
    fun saveSubTask(@Valid @RequestBody request: CreateSubTaskDto, @PathVariable id: Long): SubTaskDto {
        val todo = toDoService.getToDoById(id)
        return subTaskService.saveSubTask(request, todo.toToDoEntity())
    }

    @PutMapping("/{id}")
    fun updateSubTask(@Valid @RequestBody request: UpdateSubTaskDto, @PathVariable id: Long): SubTaskDto {
        return subTaskService.updateSubTask(request, id)
    }

    @DeleteMapping("/{id}")
    fun deleteSubTask(@PathVariable id: Long){
        subTaskService.deleteSubTask(id)
    }

}