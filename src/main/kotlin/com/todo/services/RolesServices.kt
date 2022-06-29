package com.todo.services

import com.todo.mapper.RolesMapper
import com.todo.mapper.RolesMapperImpl
import com.todo.models.RolesModel
import com.todo.repository.RoleRepository
import com.todo.requestModels.RolesRequestModel
import java.util.*

class RolesServices {

    private val rolesMapper: RolesMapper = RolesMapperImpl()

    fun saveRole(roleRepository: RoleRepository, rolesRequestModel: RolesRequestModel) {
        roleRepository.save(rolesMapper.map(rolesRequestModel))
    }

    fun findAll(roleRepository: RoleRepository): MutableIterable<RolesModel> {
        return roleRepository.findAll()
    }

    fun deleteById(roleRepository: RoleRepository, id : Int) {
        roleRepository.deleteById(id)
    }

    fun updateRoles(roleRepository: RoleRepository, rolesRequestModel: RolesRequestModel){
        roleRepository.update(rolesMapper.map(rolesRequestModel))
    }

    fun findById(roleRepository: RoleRepository, id: Int) : Optional<RolesModel> {
        return roleRepository.findById(id)
    }

    fun deleteAllRoles(roleRepository: RoleRepository){
        roleRepository.deleteAll()
    }

}