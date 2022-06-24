package com.todo.controllers

import com.todo.models.RolesModel
import com.todo.repository.RoleRepository
import com.todo.services.RolesServices
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller("/roles")
class RolesController(private val roleRepository: RoleRepository) {

    var rolesServices: RolesServices = RolesServices()

    @Get(value = "/saveRole", produces = [MediaType.APPLICATION_JSON])
    fun getAllRoles() : String {
        return try {
            rolesServices.saveRole(roleRepository)
            "True"
        }
        catch (e : Exception){
            e.toString()
        }
    }

    @Get(value = "/find", produces = [MediaType.TEXT_PLAIN])
    fun findALl() : MutableIterable<RolesModel> {
        return try {
            rolesServices.findAll(roleRepository)
        }
        catch (e : Exception) {
            println(e)
            mutableListOf<RolesModel>()
        }
    }
}