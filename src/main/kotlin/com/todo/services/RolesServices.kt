package com.todo.services

import com.todo.models.RolesModel
import com.todo.repository.RoleRepository
import java.util.*

class RolesServices {

    fun saveRole(roleRepository: RoleRepository, rolesModel: RolesModel) {
        roleRepository.save(rolesModel)
    }

    fun findAll(roleRepository: RoleRepository): MutableIterable<RolesModel> {
        return roleRepository.findAll()
    }

    fun deleteById(roleRepository: RoleRepository, id : Int) {
        roleRepository.deleteById(id)
    }

    fun updateRoles(roleRepository: RoleRepository, rolesModel: RolesModel){
        roleRepository.update(rolesModel)
    }

    fun findById(roleRepository: RoleRepository, id: Int) : Optional<RolesModel> {
        return roleRepository.findById(id)
    }

    fun deleteAllRoles(roleRepository: RoleRepository){
        roleRepository.deleteAll()
    }

}