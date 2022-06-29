package com.todo.repository

import com.todo.models.UserModel
import io.micronaut.data.jdbc.annotation.JdbcRepository
import io.micronaut.data.model.query.builder.sql.Dialect
import io.micronaut.data.repository.CrudRepository

@JdbcRepository(dialect = Dialect.MYSQL)
interface UsersRepository : CrudRepository<UserModel, Int>