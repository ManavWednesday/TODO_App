package com.todo.controllers

import com.todo.models.ResponseModel
import com.todo.models.TodoModel
import com.todo.repository.TodoRepository
import com.todo.requestModels.TodoRequestModel
import com.todo.services.TodoService
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Delete
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Put
import io.micronaut.http.annotation.QueryValue
import io.micronaut.validation.Validated
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.Optional
import javax.validation.Valid
import javax.validation.constraints.NotNull

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

    @Delete(value = "deleteAll")
    suspend fun deleteAllTodos() : HttpResponse<ResponseModel<String>> {
        return try {
            todoService.deleteAllTodos(todoRepository)
            HttpResponse.ok(withContext(Dispatchers.IO){
                ResponseModel.Success("True")
            })
        } catch (e: Exception) {
            HttpResponse.ok(withContext(Dispatchers.IO){
                ResponseModel.Error(e.toString())
            })
        }
    }

    @Get(value = "getTodoById")
    suspend fun getTodoById(@NotNull @QueryValue(value = "id") id : Int) : HttpResponse<ResponseModel<Optional<TodoModel>>>{
        return try {
            HttpResponse.ok(withContext(Dispatchers.IO){
                ResponseModel.Success(todoService.getTodoById(todoRepository, id))
            })
        } catch (e: Exception) {
            HttpResponse.ok(withContext(Dispatchers.IO){
                ResponseModel.Error(e.toString())
            })
        }
    }

    @Get(value = "getAllUserTodo")
    suspend fun getAllUserTodo(@NotNull @QueryValue(value = "user_id") userId: Int) : HttpResponse<ResponseModel<List<TodoModel>>> {
        return try {
            HttpResponse.ok(withContext(Dispatchers.IO){
                ResponseModel.Success(todoService.getAllUserTodos(todoRepository, userId))
            })
        } catch (e: Exception) {
            HttpResponse.ok(withContext(Dispatchers.IO){
                ResponseModel.Error(e.toString())
            })
        }
    }

    @Delete(value = "deleteTodoById")
    suspend fun deleteTodoById(@NotNull @QueryValue(value = "id") id: Int) : HttpResponse<ResponseModel<String>> {
        return try {
            todoService.deleteTodoById(todoRepository, id)
            HttpResponse.ok(withContext(Dispatchers.IO){
                ResponseModel.Success("True")
            })
        } catch (e: Exception) {
            HttpResponse.ok(withContext(Dispatchers.IO){
                ResponseModel.Error(e.toString())
            })
        }
    }

}