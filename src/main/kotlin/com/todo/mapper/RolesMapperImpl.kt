package com.todo.mapper

import com.todo.models.RolesModel
import com.todo.requestModels.RolesRequestModel

interface RolesMapper : Mapper<RolesRequestModel, RolesModel>

class RolesMapperImpl : RolesMapper {
    override fun map(from: RolesRequestModel): RolesModel {
        return RolesModel(
                id = from.id,
                accessLevel = from.accessLevel,
                name = from.name)
    }
}