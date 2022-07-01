package com.todo.mapper

import com.todo.models.UserModel
import com.todo.requestModels.UserRequestModel
import com.todo.utils.UserPasswordHashingSha256
import java.security.NoSuchAlgorithmException
import java.sql.Timestamp

interface UserMapper : Mapper<UserRequestModel, UserModel>

class UserMapperImpl : UserMapper {
    @Throws(NoSuchAlgorithmException::class)
    override fun map(from: UserRequestModel): UserModel {
        return UserModel(
                id = from.id,
                firstName = from.firstName,
                lastName = from.lastName,
                userName = from.userName,
                password = UserPasswordHashingSha256.hashPassword(from.password),
                email = from.email,
                mobile = from.mobile,
                roleId = from.roleId,
                createdAt = from.createdAt?: Timestamp(System.currentTimeMillis()),
                updatedAt = null,
                deletedAt = null
        )
    }

}