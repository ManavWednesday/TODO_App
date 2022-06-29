package com.todo.models

import io.micronaut.data.annotation.DateCreated
import io.micronaut.data.annotation.DateUpdated
import io.micronaut.data.annotation.GeneratedValue
import io.micronaut.data.annotation.MappedEntity
import java.sql.Timestamp
import javax.persistence.Column
import javax.persistence.Id
import javax.persistence.PreUpdate
import javax.validation.constraints.NotNull

@MappedEntity(value = "todos")
data class TodoModel(
        @Id
        @GeneratedValue(value = GeneratedValue.Type.AUTO)
        val id: Int = 0,
        @Column(name = "user_id")
        val userId: Int,
        @Column(name = "title")
        val title: String,
        @Column(name = "description")
        val description: String,
        @Column(name = "due_date")
        val dueDate: Timestamp?,
        @Column(name = "done")
        val done: Int,
        @NotNull
        @DateCreated
        @Column(name = "created_at")
        val createdAt: Timestamp,
        @DateUpdated
        @Column(name = "updated_at")
        var updatedAt: Timestamp?,
        @Column(name = "deleted_at")
        val deletedAt: Timestamp?
) {
        @PreUpdate
        fun updateTime() {
                updatedAt = Timestamp(System.currentTimeMillis())
        }
}
