package com.todo.controllers

import com.todo.models.ResponseModel
import com.todo.repository.TodoRepository
import com.todo.requestModels.TodoRequestModel
import com.todo.services.TodoService
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Put
import io.micronaut.validation.Validated
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.validation.Valid

@Validated
@Controller(value = "todo" )
class TodoController(private val todoRepository: TodoRepository) {

    private val todoService = TodoService()

    @Post(value = "addTodo")
    suspend fun addTodo(@Body @Valid todoRequestModel: TodoRequestModel) : HttpResponse<ResponseModel<String>> {
        return try {
            todoService.addTodo(todoRepository, todoRequestModel)
            HttpResponse.ok(withContext(Dispatchers.IO){
                ResponseModel.Success("True")
            })
        } catch (e: Exception) {
            HttpResponse.ok(withContext(Dispatchers.IO){
                ResponseModel.Error(e.toString())
            })
        }
    }

    @Put(value = "updateTodo")
    suspend fun updateTodo(@Body @Valid todoRequestModel: TodoRequestModel) : HttpResponse<ResponseModel<String>> {
        return try {
            todoService.updateTodo(todoRepository, todoRequestModel)
            HttpResponse.ok(withContext(Dispatchers.IO){
                ResponseModel.Success("Updated")
            })
        } catch (e: Exception) {
            HttpResponse.ok(withContext(Dispatchers.IO){
                ResponseModel.Error(e.toString())
            })
        }
    }

}