package com.todo.models

import io.micronaut.data.annotation.GeneratedValue
import java.sql.Timestamp
import javax.persistence.Column
import javax.persistence.Id

data class TodoModel(
        @Id
        @GeneratedValue(value = GeneratedValue.Type.AUTO)
        val id : Int = 0,
        @Column(name = "user_id")
        val userId: Int,
        @Column(name = "title")
        val title: String,
        @Column(name = "description")
        val description: String,
        @Column(name = "due_date")
        val dueDate: Timestamp,
        @Column(name = "done")
        val done: Int,
        @Column(name = "created_at")
        val createdAt: Timestamp,
        @Column(name = "updated_at")
        val updatedAt: Timestamp,
        @Column(name = "deleted_at")
        val deletedAt: Timestamp
)
