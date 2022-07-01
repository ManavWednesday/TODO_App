package com.todo.utils

import java.math.BigInteger
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

object UserPasswordHashingSha256 {

    fun hashPassword(password : String) : String {
        return try {
            val md = MessageDigest.getInstance("SHA-256")
            val messageDigest = md.digest(password.toByteArray())
            val no = BigInteger(1, messageDigest)
            var hashText = no.toString(16)
            while ( hashText.length < 32) {
                hashText = "0$hashText"
            }
            hashText
        } catch (e: NoSuchAlgorithmException) {
            throw RuntimeException(e)
        }
    }
}