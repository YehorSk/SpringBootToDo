package com.yehorsk.todotest.todos.repository.entities

import com.yehorsk.todotest.subtasks.repository.entitities.SubTaskEntity
import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.Instant

@Entity
@Table(name = "todos")
class ToDoEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var description: String = "",
    @Column(nullable = false)
    var name: String = "",
    @OneToMany(
        mappedBy = "todo",
        cascade = [CascadeType.ALL],
        orphanRemoval = true
    )
    var subTasks: MutableSet<SubTaskEntity> = mutableSetOf(),
    @CreationTimestamp
    var createdAt: Instant = Instant.now(),
    @UpdateTimestamp
    var updatedAt: Instant = Instant.now()
){
    fun addSubTasks(subTasks: Set<SubTaskEntity>){
        subTasks.forEach { addSubTask(it) }
    }

    fun addSubTask(subTask: SubTaskEntity) {
        this.subTasks.add(subTask)
        subTask.todo = this
    }
}