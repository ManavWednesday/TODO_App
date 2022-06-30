package com.todo.requestModels

import java.sql.Timestamp
import javax.validation.constraints.NotNull

data class RolesRequestModel(
        var id: Int = 0,
        @NotNull
        var accessLevel: Int,
        var name: String,
        var createdAt: Timestamp?,
        var updatedAt: Timestamp?,
        var deletedAt: Timestamp?
)
