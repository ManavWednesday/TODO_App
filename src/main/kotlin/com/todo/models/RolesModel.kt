package com.todo.models

import io.micronaut.data.annotation.DateCreated
import io.micronaut.data.annotation.DateUpdated
import io.micronaut.data.annotation.GeneratedValue
import io.micronaut.data.annotation.MappedEntity
import java.sql.Timestamp
import javax.persistence.Column
import javax.persistence.Id
import javax.persistence.PreUpdate
import javax.validation.constraints.NotNull

@MappedEntity(value = "roles")
data class RolesModel(
        @Id
        @GeneratedValue(value = GeneratedValue.Type.AUTO)
        var id: Int = 0,
        @NotNull
        var accessLevel: Int,
        var name: String,
        @NotNull
        @DateCreated
        @Column(name = "created_at")
        val createdAt: Timestamp,
        @DateUpdated
        @Column(name = "updated_at")
        var updatedAt: Timestamp?,
        @Column(name = "deleted_at")
        val deletedAt: Timestamp?) {
    @PreUpdate
    fun updateTime() {
        updatedAt = Timestamp(System.currentTimeMillis())
    }
}
