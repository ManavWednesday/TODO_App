package com.todo.controllers

import com.todo.models.ResponseModel
import com.todo.models.RolesModel
import com.todo.repository.RoleRepository
import com.todo.services.RolesServices
import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.QueryValue
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@Controller("/roles")
class RolesController(private val roleRepository: RoleRepository) {

    private var rolesServices: RolesServices = RolesServices()

    @Post(value = "/saveRole", produces = [MediaType.APPLICATION_JSON])
    suspend fun getAllRoles(@QueryValue(value = "level") level: Int, @QueryValue(value = "name") name: String) : String {
        return try {
            val rolesModel = RolesModel(accessLevel = level, name =  name)
            rolesServices.saveRole(roleRepository, rolesModel)
            "True"
        }
        catch (e : Exception){
            e.toString()
        }
    }

    @Get(value = "/find", produces = [MediaType.APPLICATION_JSON])
    suspend fun findALl() : HttpResponse<ResponseModel<MutableIterable<RolesModel>>> {
        return try {
            HttpResponse.ok(withContext(Dispatchers.IO){
                ResponseModel.Success<MutableIterable<RolesModel>>(rolesServices.findAll(roleRepository))
            })
        }
        catch (e : Exception) {
            println(e)
            HttpResponse.ok(withContext(Dispatchers.IO){
                ResponseModel.Error(e.toString(), null)
            } )
        }
    }
}