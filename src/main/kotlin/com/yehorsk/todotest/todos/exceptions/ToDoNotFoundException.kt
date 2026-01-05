package com.yehorsk.todotest.todos.exceptions

class ToDoNotFoundException(
    id: Long
): RuntimeException(
    "A todo with ID $id not found"
)
