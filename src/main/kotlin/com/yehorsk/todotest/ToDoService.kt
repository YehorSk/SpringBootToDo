package com.yehorsk.todotest

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

    fun updateToDo(toDoDto: ToDoDto): ToDoDto {
        val newToDo = toDoRepository.save(toDoDto.toToDoEntity())
        return newToDo.toToDoDto()
    }

    fun deleteToDo(toDoDto: ToDoDto) {
        toDoRepository.delete(toDoDto.toToDoEntity())
    }

}