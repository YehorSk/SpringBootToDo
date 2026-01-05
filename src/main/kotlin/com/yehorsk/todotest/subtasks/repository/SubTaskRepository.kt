package com.yehorsk.todotest.subtasks.repository

import com.yehorsk.todotest.subtasks.repository.entitities.SubTaskEntity
import org.springframework.data.repository.CrudRepository

interface SubTaskRepository: CrudRepository<SubTaskEntity, Long> {

}