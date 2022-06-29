package com.todo.mapper

import com.todo.models.TodoModel
import com.todo.requestModels.TodoRequestModel
import java.sql.Timestamp

interface TodoMapper : Mapper <TodoRequestModel,TodoModel>

class TodoMapperImpl : TodoMapper {
    override fun map(from: TodoRequestModel): TodoModel {
        return TodoModel(
                id = from.id,
                userId = from.userId,
                title = from.title,
                description = from.description,
                dueDate = from.dueDate,
                done = from.done,
                createdAt = from.createdAt?: Timestamp(System.currentTimeMillis()),
                updatedAt = null,
                deletedAt = null
        )
    }

}