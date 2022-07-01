package com.todo.services

import com.todo.mapper.TodoMapperImpl
import com.todo.models.TodoModel
import com.todo.repository.TodoRepository
import com.todo.requestModels.TodoRequestModel
import java.sql.Timestamp
import java.util.*

class TodoService {

    private val todoMapper = TodoMapperImpl()
    fun addTodo(todoRepository: TodoRepository, todoRequestModel: TodoRequestModel) {
        todoRequestModel.createdAt = Timestamp(System.currentTimeMillis())
        todoRepository.save(todoMapper.map(todoRequestModel))
    }

    fun updateTodo(todoRepository: TodoRepository, todoRequestModel: TodoRequestModel) {
        todoRepository.update(todoMapper.map(todoRequestModel))
    }

    fun deleteAllTodos(todoRepository: TodoRepository) {
        todoRepository.deleteAll()
    }

    fun getTodoById(todoRepository: TodoRepository, id: Int) : Optional<TodoModel> {
        return todoRepository.findById(id)
    }

    fun getAllUserTodos(todoRepository: TodoRepository, userId: Int): List<TodoModel> {
        return todoRepository.findAllByUserId(userId)
    }

    fun deleteTodoById(todoRepository: TodoRepository, id: Int) {
        todoRepository.deleteById(id)
    }
}