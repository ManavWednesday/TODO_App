package com.todo.controllers

import com.todo.models.ResponseModel
import com.todo.models.UserModel
import com.todo.repository.UsersRepository
import com.todo.requestModels.UserRequestModel
import com.todo.services.UserService
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
import javax.validation.Valid

@Validated
@Controller(value = "users")
class UserController(private val usersRepository: UsersRepository) {

    private val userService = UserService()

    @Get(value = "findAll")
    suspend fun findAll(): HttpResponse<ResponseModel<MutableIterable<UserModel>>> {
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
    suspend fun addUser(@Body @Valid userRequestModel: UserRequestModel) : HttpResponse<ResponseModel<String>>{
        return try {
            userService.addUser(usersRepository, userRequestModel)
            HttpResponse.ok(withContext(Dispatchers.IO){
                ResponseModel.Success("True")
            })
        } catch (e: Exception) {
            HttpResponse.ok(withContext(Dispatchers.IO){
                ResponseModel.Error(e.toString())
            })
        }
    }

    @Delete(value = "deleteUserById")
    suspend fun deleteUserById(@QueryValue(value = "id") id: Int) : HttpResponse<ResponseModel<String>> {
        return try {
            userService.deleteUserById(usersRepository, id)
            HttpResponse.ok(withContext(Dispatchers.IO){
                ResponseModel.Success("True")
            })
        } catch (e: Exception){
            HttpResponse.ok(withContext(Dispatchers.IO){
                ResponseModel.Error("False")
            })
        }
    }

    @Put(value = "updateUser")
    suspend fun updateUserById(@Body @Valid userRequestModel: UserRequestModel) : HttpResponse<ResponseModel<String>> {
        return try {
            userService.updateUser(usersRepository, userRequestModel)
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