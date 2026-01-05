package com.yehorsk.todotest.subtasks.exceptions

class SubTaskNotFoundException(
    id: Long
): RuntimeException(
    "A subtask with ID $id not found"
)