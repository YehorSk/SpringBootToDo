package com.yehorsk.todotest.todos.service

import com.yehorsk.todotest.subtasks.repository.entitities.SubTaskEntity
import com.yehorsk.todotest.todos.toToDoDto
import com.yehorsk.todotest.todos.toToDoEntity
import com.yehorsk.todotest.todos.exceptions.ToDoNotFoundException
import com.yehorsk.todotest.todos.repository.ToDoRepository
import com.yehorsk.todotest.todos.service.dtos.requests.CreateToDoDto
import com.yehorsk.todotest.todos.service.dtos.responses.ToDoDto
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class ToDoService(
    private val toDoRepository: ToDoRepository
) {

    fun getAll(): List<ToDoDto> {
        return toDoRepository.findAll().map { it.toToDoDto() }
    }

    fun getToDoById(id: Long): ToDoDto {
        val todo = toDoRepository.findById(id)
            .orElseThrow{ throw ToDoNotFoundException(id) }
        return todo.toToDoDto()
    }

    @Transactional
    fun saveToDo(request: CreateToDoDto): ToDoDto {
        val todo = request.toToDoEntity()
        todo.addSubTasks(
            request.subTasks.map {
                SubTaskEntity(
                    name = it.name,
                    description = it.description
                )
            }.toSet()
        )
        return toDoRepository.save(todo).toToDoDto()
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