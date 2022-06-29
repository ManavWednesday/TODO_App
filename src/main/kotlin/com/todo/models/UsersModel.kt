package com.todo.models

import io.micronaut.data.annotation.GeneratedValue
import io.micronaut.data.annotation.MappedEntity
import javax.persistence.Column
import javax.persistence.Id

@MappedEntity(value = "users")
data class UsersModel(
        @Id
        @GeneratedValue(value = GeneratedValue.Type.AUTO)
        val id : Int = 0,
        @Column(name = "first_name")
        val firstName : String,
        @Column(name = "last_name")
        val lastName : String,
        @Column(name = "username")
        val userName : String,
        @Column(name = "password")
        val password : String,
        @Column(name = "email")
        val email : String,
        @Column(name = "mobile")
        val mobile : Int,
        @Column(name = "role_id")
        val roleId : Int
)
