package com.jnicovm.minitwitter.models

data class LoginModel(
        val password: String,
        val email: String,
        val code: String = "UDEMYANDROID") {

    override fun toString(): String {
        return email
    }
}