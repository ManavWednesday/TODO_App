package com.todo.models

sealed class ResponseModel<T>(
        val status: Int? = null,
        val message:String? = null,
        val data: T?
) {

    class Success<T>(data: T) : ResponseModel<T>(1, "Success", data)

    class Error<T>(message: String?, data: T? = null) : ResponseModel<T>(0, message, data)
}
