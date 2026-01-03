package com.yehorsk.todotest.exceptions

import java.time.LocalDateTime

data class Response<T:Any>(
    val data: T? = null,
    val message: String? = null,
    val status: Int = 200,
    val timeStamp: LocalDateTime = LocalDateTime.now()
)
