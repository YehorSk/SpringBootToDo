package com.yehorsk.todotest.exceptions

class ToDoNotFoundException(
    id: Long
): RuntimeException(
    "A todo with ID $id not found"
)
