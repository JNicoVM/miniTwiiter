package com.jnicovm.minitwitter.models

data class AccountModel(
        val userName: String,
        val password: String,
        val email: String) {

    override fun toString(): String {
        return userName
    }

}