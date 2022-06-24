package com.todo.models

import io.micronaut.data.annotation.MappedEntity
import javax.persistence.Id
import javax.validation.constraints.NotNull

@MappedEntity(value = "roles")
data class RolesModel(
        @Id
        var id: Int,
        @NotNull
        var accessLevel: Int,
        var name: String
        )
