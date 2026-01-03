package com.yehorsk.todotest.exceptions.todos

class ToDoNotFoundException(
    id: Long
): RuntimeException(
    "A todo with ID $id not found"
)
