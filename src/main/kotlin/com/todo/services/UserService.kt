package com.todo.services

import com.todo.models.UsersModel
import com.todo.repository.UsersRepository

class UserService {

    fun findAllUsers(usersRepository: UsersRepository): MutableIterable<UsersModel> {
        return usersRepository.findAll()
    }

    fun addUser(usersRepository: UsersRepository, usersModel: UsersModel) {
        usersRepository.save(usersModel)
    }
}