package com.todo.models

import io.micronaut.data.annotation.GeneratedValue
import io.micronaut.data.annotation.MappedEntity
import javax.persistence.Id
import javax.validation.constraints.NotNull

@MappedEntity(value = "roles")
data class RolesModel(
        @Id
        @GeneratedValue(value = GeneratedValue.Type.AUTO)
        var id: Int = 0,
        @NotNull
        var accessLevel: Int,
        var name: String
        )
