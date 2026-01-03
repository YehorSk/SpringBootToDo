package com.yehorsk.todotest.repository

import com.yehorsk.todotest.repository.model.SubTaskEntity
import org.springframework.data.repository.CrudRepository

interface SubTaskRepository: CrudRepository<SubTaskEntity, Long> {

}