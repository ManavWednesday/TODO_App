package com.todo.services

import com.todo.models.RolesModel
import com.todo.repository.RoleRepository

class RolesServices {

    fun saveRole(roleRepository: RoleRepository) {
        val rolesModel = RolesModel(4,2, "User")
        roleRepository.save(rolesModel)
    }

    fun findAll(roleRepository: RoleRepository): MutableIterable<RolesModel> {
        val data = roleRepository.findAll()
        println(data)
        return data
    }

}