package com.todo.repository

import com.todo.models.TodoModel
import io.micronaut.data.annotation.Query
import io.micronaut.data.jdbc.annotation.JdbcRepository
import io.micronaut.data.model.query.builder.sql.Dialect
import io.micronaut.data.repository.CrudRepository

@JdbcRepository(dialect = Dialect.MYSQL)
interface TodoRepository : CrudRepository<TodoModel, Int> {

    @Query("SELECT * FROM todos WHERE user_id = :userId")
    fun findAllByUserId(userId: Int): List<TodoModel>
}