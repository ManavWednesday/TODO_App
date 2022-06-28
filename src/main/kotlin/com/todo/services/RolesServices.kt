package com.todo.services

import com.todo.models.RolesModel
import com.todo.repository.RoleRepository

class RolesServices {

    fun saveRole(roleRepository: RoleRepository, rolesModel: RolesModel) {
        roleRepository.save(rolesModel)
    }

    fun findAll(roleRepository: RoleRepository): MutableIterable<RolesModel> {
        return roleRepository.findAll()
    }

}