package com.todo.requestModels

import java.sql.Timestamp

data class TodoRequestModel(

        val id : Int = 0,
        val userId: Int,
        val title: String,
        val description: String,
        val dueDate: Timestamp?,
        val done: Int,
        var createdAt: Timestamp?,
        var updatedAt: Timestamp?,
        var deletedAt: Timestamp?
)
