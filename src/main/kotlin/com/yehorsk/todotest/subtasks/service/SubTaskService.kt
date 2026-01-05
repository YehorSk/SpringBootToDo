package com.yehorsk.todotest.subtasks.service

import com.yehorsk.todotest.subtasks.exceptions.SubTaskNotFoundException
import com.yehorsk.todotest.subtasks.repository.SubTaskRepository
import com.yehorsk.todotest.subtasks.repository.entitities.SubTaskEntity
import com.yehorsk.todotest.subtasks.service.dtos.requests.CreateSubTaskDto
import com.yehorsk.todotest.subtasks.service.dtos.requests.UpdateSubTaskDto
import com.yehorsk.todotest.subtasks.service.dtos.responses.SubTaskDto
import com.yehorsk.todotest.todos.toSubTaskDto
import com.yehorsk.todotest.todos.repository.entities.ToDoEntity
import org.springframework.stereotype.Service

@Service
class SubTaskService(
    private val subTaskRepository: SubTaskRepository
) {

    fun getById(id: Long): SubTaskDto{
        val subtask = subTaskRepository.findById(id)
            .orElseThrow{ throw SubTaskNotFoundException(id) }
        return subtask.toSubTaskDto()
    }

    fun saveSubTask(request: CreateSubTaskDto, toDo: ToDoEntity): SubTaskDto {
        val subTask = SubTaskEntity(
            name = request.name,
            description = request.description,
            todo = toDo
        )
        return subTaskRepository.save(subTask).toSubTaskDto()
    }

    fun updateSubTask(request: UpdateSubTaskDto, id: Long): SubTaskDto {
        val subtask = subTaskRepository.findById(id)
            .orElseThrow{ throw SubTaskNotFoundException(id) }
        request.name?.let { subtask.name = it }
        request.description?.let { subtask.description = it }
        return subTaskRepository.save(subtask).toSubTaskDto()
    }

    fun deleteSubTask(id: Long){
        val subtask = subTaskRepository.findById(id)
            .orElseThrow{ throw SubTaskNotFoundException(id) }
        subTaskRepository.deleteById(id)
    }

}