package com.todo.controllers

import com.todo.models.ResponseModel
import com.todo.models.UsersModel
import com.todo.repository.UsersRepository
import com.todo.services.UserService
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import io.micronaut.validation.Validated
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.validation.Valid

@Validated
@Controller(value = "users")
class UserController(private val usersRepository: UsersRepository) {

    private val userService = UserService()

    @Get(value = "findAll")
    suspend fun findAll(): HttpResponse<ResponseModel<MutableIterable<UsersModel>>> {
        return try {
            HttpResponse.ok(withContext(Dispatchers.IO) {
                ResponseModel.Success(userService.findAllUsers(usersRepository))
            })
        } catch (e: Exception) {
            HttpResponse.ok(withContext(Dispatchers.IO) {
                ResponseModel.Error(e.toString())
            })
        }
    }

    @Post(value = "addUser")
    suspend fun addUser(@Body @Valid usersModel: UsersModel) : HttpResponse<ResponseModel<String>>{
        return try {
            userService.addUser(usersRepository, usersModel)
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