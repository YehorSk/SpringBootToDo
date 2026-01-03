package com.yehorsk.todotest.service

import com.yehorsk.todotest.exceptions.todos.ToDoNotFoundException
import com.yehorsk.todotest.service.model.ToDoDto
import com.yehorsk.todotest.repository.ToDoRepository
import com.yehorsk.todotest.service.model.CreateToDoDto
import com.yehorsk.todotest.toToDoDto
import com.yehorsk.todotest.toToDoEntity
import org.springframework.stereotype.Service

@Service
class ToDoService(
    private val toDoRepository: ToDoRepository,
    private val subTaskService: SubTaskService
) {

    fun getAll(): List<ToDoDto> {
        return toDoRepository.findAll().map { it.toToDoDto() }
    }

    fun getToDoById(id: Long): ToDoDto {
        val todo = toDoRepository.findById(id)
            .orElseThrow{ throw ToDoNotFoundException(id)}
        return todo.toToDoDto()
    }

    fun saveToDo(request: CreateToDoDto): ToDoDto {
        val newToDo = toDoRepository.save(request.toToDoEntity())
        request.subTasks.forEach { task ->
            subTaskService.saveSubTask(task, newToDo.id!!)
        }
        return newToDo.toToDoDto()
    }

    fun updateToDo(id: Long, toDoDto: ToDoDto): ToDoDto {
        val existing = toDoRepository.findById(id)
            .orElseThrow{ ToDoNotFoundException(id) }
        existing.name = toDoDto.name
        existing.description = toDoDto.description
        val newToDo = toDoRepository.save(existing)
        return newToDo.toToDoDto()
    }

    fun deleteToDo(id: Long) {
        toDoRepository.findById(id)
            .orElseThrow{ ToDoNotFoundException(id) }
        toDoRepository.deleteById(id)
    }

}