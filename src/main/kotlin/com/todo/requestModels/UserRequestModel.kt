package com.todo.requestModels

import javax.validation.constraints.NotNull

data class UserRequestModel(
        val id : Int = 0,
        val firstName : String,
        val lastName : String,
        @NotNull
        val userName : String,
        val password : String,
        @NotNull
        val email : String,
        val mobile : Int,
        val roleId : Int
)
