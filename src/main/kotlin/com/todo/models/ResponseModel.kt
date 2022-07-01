package com.todo.models

sealed class ResponseModel<T>(
        val message:String? = null,
        val data: T?,
        val error: String?
) {

    class Success<T>(data: T) : ResponseModel<T>( "Success", data, null)

    class Error<T>(message: String?, error: String? = null) : ResponseModel<T>(message, null, error)
}
