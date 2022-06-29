package com.todo.services

import com.todo.mapper.TodoMapperImpl
import com.todo.repository.TodoRepository
import com.todo.requestModels.TodoRequestModel
import java.sql.Timestamp

class TodoService {

    private val todoMapper = TodoMapperImpl()
    fun addTodo(todoRepository: TodoRepository, todoRequestModel: TodoRequestModel) {
        todoRequestModel.createdAt = Timestamp(System.currentTimeMillis())
        todoRepository.save(todoMapper.map(todoRequestModel))
    }

    fun updateTodo(todoRepository: TodoRepository, todoRequestModel: TodoRequestModel) {
        todoRepository.update(todoMapper.map(todoRequestModel))
    }
}