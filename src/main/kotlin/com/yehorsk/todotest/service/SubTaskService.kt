package com.yehorsk.todotest.service

import com.yehorsk.todotest.exceptions.todos.ToDoNotFoundException
import com.yehorsk.todotest.repository.SubTaskRepository
import com.yehorsk.todotest.repository.ToDoRepository
import com.yehorsk.todotest.repository.model.SubTaskEntity
import com.yehorsk.todotest.service.model.CreateSubTaskDto
import com.yehorsk.todotest.service.model.SubTaskDto
import com.yehorsk.todotest.toSubTaskDto
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class SubTaskService(
    private val subTaskRepository: SubTaskRepository,
    private val toDoRepository: ToDoRepository
) {

    fun saveSubTask(request: CreateSubTaskDto, toDoId: Long): SubTaskDto{
        val todo = toDoRepository.findById(toDoId)
            .orElseThrow{ throw ToDoNotFoundException(toDoId)}
        val subTask = SubTaskEntity(
            name = request.name,
            description = request.description,
        ).apply {
            this.todo = todo
        }
        return subTaskRepository.save(subTask).toSubTaskDto()
    }

}