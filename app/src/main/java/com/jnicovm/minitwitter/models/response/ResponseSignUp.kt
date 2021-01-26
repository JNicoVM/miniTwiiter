package com.jnicovm.minitwitter.models.response

import com.google.gson.annotations.SerializedName

data class ResponseSignUp (
    @SerializedName("token")
    val token: String,
    @SerializedName("username")
    val username: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("photoURL")
    val photoURL: String,
    @SerializedName("created")
    val created: String,
    @SerializedName("active")
    val active: Boolean
)