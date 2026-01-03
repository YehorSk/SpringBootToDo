package com.yehorsk.todotest.repository.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "sub_tasks")
class SubTaskEntity(
    var description: String = "",
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    @Column(nullable = false)
    var name: String = "",
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
    name = "todo_id",
    referencedColumnName = "id"
    )
    var todo: ToDoEntity? = null
)