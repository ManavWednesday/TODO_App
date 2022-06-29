package com.todo.requestModels

import javax.validation.constraints.NotNull

data class RolesRequestModel(
        var id: Int = 0,
        @NotNull
        var accessLevel: Int,
        var name: String
)
