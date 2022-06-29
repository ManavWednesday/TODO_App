package com.todo.models

import io.micronaut.data.annotation.GeneratedValue
import io.micronaut.data.annotation.MappedEntity
import javax.persistence.Column
import javax.persistence.Id
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
        val roleId : Int
)
