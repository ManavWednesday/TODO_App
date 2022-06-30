package com.todo.mapper

import com.todo.models.RolesModel
import com.todo.requestModels.RolesRequestModel
import java.sql.Timestamp

interface RolesMapper : Mapper<RolesRequestModel, RolesModel>

class RolesMapperImpl : RolesMapper {
    override fun map(from: RolesRequestModel): RolesModel {
        return RolesModel(
                id = from.id,
                accessLevel = from.accessLevel,
                name = from.name,
                createdAt = from.createdAt?: Timestamp(System.currentTimeMillis()),
                updatedAt = null,
                deletedAt = null
        )
    }
}