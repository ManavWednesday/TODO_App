package com.todo.controllers

import com.todo.models.ResponseModel
import com.todo.models.RolesModel
import com.todo.repository.RoleRepository
import com.todo.services.RolesServices
import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
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
@Controller("/roles")
class RolesController(private val roleRepository: RoleRepository) {

    private var rolesServices: RolesServices = RolesServices()

    @Post(value = "/saveRole", produces = [MediaType.APPLICATION_JSON])
    suspend fun saveRole(@NotNull @QueryValue(value = "level") level: Int, @QueryValue(value = "name") name: String): HttpResponse<ResponseModel<String>> {
        return try {
            val rolesModel = RolesModel(accessLevel = level, name = name)
            rolesServices.saveRole(roleRepository, rolesModel)
            HttpResponse.ok(withContext(Dispatchers.IO) {
                ResponseModel.Success("True")
            })
        } catch (e: Exception) {
            HttpResponse.ok(withContext(Dispatchers.IO) {
                ResponseModel.Error(e.toString())
            })
        }
    }

    @Get(value = "/find", produces = [MediaType.APPLICATION_JSON])
    suspend fun findAll(): HttpResponse<ResponseModel<MutableIterable<RolesModel>>> {
        return try {
            HttpResponse.ok(withContext(Dispatchers.IO) {
                ResponseModel.Success(rolesServices.findAll(roleRepository))
            })
        } catch (e: Exception) {
            HttpResponse.ok(withContext(Dispatchers.IO) {
                ResponseModel.Error(e.toString(), null)
            })
        }
    }

    @Delete(value = "/delete", produces = [MediaType.APPLICATION_JSON])
    suspend fun deleteRoleById(@NotNull @QueryValue(value = "id") id: Int): HttpResponse<ResponseModel<String>> {
        return try {
            rolesServices.deleteById(roleRepository, id)
            HttpResponse.ok(withContext(Dispatchers.IO) {
                ResponseModel.Success("True")
            })
        } catch (e: Exception) {
            HttpResponse.ok(withContext(Dispatchers.IO) {
                ResponseModel.Error(e.toString())
            })
        }
    }

    @Put(value = "/update")
    suspend fun updateRole(@Body @Valid rolesModel: RolesModel): HttpResponse<ResponseModel<String>> {
        return try {
            rolesServices.updateRoles(roleRepository, rolesModel)
            HttpResponse.ok(withContext(Dispatchers.IO) {
                ResponseModel.Success("True")
            })
        } catch (e: Exception) {
            HttpResponse.ok(withContext(Dispatchers.IO) {
                ResponseModel.Error(e.toString())
            })
        }
    }

    @Get(value = "/findById")
    suspend fun findRoleById(@NotNull @QueryValue("id") id: Int): HttpResponse<ResponseModel<Optional<RolesModel>>> {
        return try {
            HttpResponse.ok(withContext(Dispatchers.IO) {
                ResponseModel.Success(rolesServices.findById(roleRepository, id))
            })
        } catch (e: Exception) {
            HttpResponse.ok(withContext(Dispatchers.IO) {
                ResponseModel.Error(e.toString())
            })
        }
    }

    @Delete(value = "deleteAll")
    suspend fun deleteRoles(): HttpResponse<ResponseModel<String>> {
        return try {
            rolesServices.deleteAllRoles(roleRepository)
            HttpResponse.ok(withContext(Dispatchers.IO) {
                ResponseModel.Success("True")
            })
        } catch (e: Exception) {
            HttpResponse.ok(withContext(Dispatchers.IO) {
                ResponseModel.Error(e.toString())
            })
        }
    }
}