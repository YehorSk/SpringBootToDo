package com.yehorsk.todotest.exceptions

import java.time.LocalDateTime

data class Response<T:Any>(
    val data: T? = null,
    val message: String?,
    val status: Int?,
    val timeStamp: LocalDateTime = LocalDateTime.now()
)
