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

@MappedEntity(value = "users")
data class UserModel(
        @Id
        @GeneratedValue(value = GeneratedValue.Type.AUTO)
        val id : Int = 0,
        @Column(name = "first_name")
        val firstName : String,
        @Column(name = "last_name")
        val lastName : String,
        @NotNull
        @Column(name = "username")
        val userName : String,
        @Column(name = "password")
        val password : String,
        @NotNull
        @Column(name = "email")
        val email : String,
        @Column(name = "mobile")
        val mobile : Int,
        @Column(name = "role_id")
        val roleId : Int,
        @NotNull
        @DateCreated
        @Column(name = "created_at")
        val createdAt: Timestamp,
        @DateUpdated
        @Column(name = "updated_at")
        var updatedAt: Timestamp?,
        @Column(name = "deleted_at")
        val deletedAt: Timestamp?
){
        @PreUpdate
        fun updateTime() {
                updatedAt = Timestamp(System.currentTimeMillis())
        }
}
