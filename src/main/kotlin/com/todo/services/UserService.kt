package com.todo.services

import com.todo.mapper.UserMapperImpl
import com.todo.models.UserModel
import com.todo.repository.UsersRepository
import com.todo.requestModels.UserRequestModel

class UserService {

    private val userMapper = UserMapperImpl()

    fun findAllUsers(usersRepository: UsersRepository): MutableIterable<UserModel> {
        return usersRepository.findAll()
    }

    fun addUser(usersRepository: UsersRepository, userRequestModel: UserRequestModel) {
        usersRepository.save(userMapper.map(userRequestModel))
    }

    fun deleteUserById(usersRepository: UsersRepository, id: Int) {
        usersRepository.deleteById(id)
    }

    fun updateUser(usersRepository: UsersRepository, userRequestModel: UserRequestModel) {
        usersRepository.update(userMapper.map(userRequestModel))
    }
}