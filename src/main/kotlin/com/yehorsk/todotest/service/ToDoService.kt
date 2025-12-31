package com.yehorsk.todotest.service

import com.yehorsk.todotest.service.model.ToDoDto
import com.yehorsk.todotest.repository.ToDoRepository
import com.yehorsk.todotest.toToDoDto
import com.yehorsk.todotest.toToDoEntity
import org.springframework.stereotype.Service

@Service
class ToDoService(
    private val toDoRepository: ToDoRepository
) {

    fun getAll(): List<ToDoDto> {
        return toDoRepository.findAll().map { it.toToDoDto() }
    }

    fun saveToDo(toDoDto: ToDoDto): ToDoDto {
        val newToDo = toDoRepository.save(toDoDto.toToDoEntity())
        return newToDo.toToDoDto()
    }

    fun updateToDo(id: Long, toDoDto: ToDoDto): ToDoDto {
        val existing = toDoRepository.findById(id)
            .orElseThrow{ NoSuchElementException("ToDo not found!") }
        val updated = existing.copy(
            name = toDoDto.name,
            description = toDoDto.description
        )
        val newToDo = toDoRepository.save(updated)
        return newToDo.toToDoDto()
    }

    fun deleteToDo(id: Long) {
        toDoRepository.findById(id)
            .orElseThrow{ NoSuchElementException("ToDo not found!") }
        toDoRepository.deleteById(id)
    }

}