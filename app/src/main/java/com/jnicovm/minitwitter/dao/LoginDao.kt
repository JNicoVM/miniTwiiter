package com.jnicovm.minitwitter.dao

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.jnicovm.minitwitter.models.LoginModel
import com.jnicovm.minitwitter.models.request.RequestLogin

class LoginDao {

    private var email = MutableLiveData<String>()
    private var userName = MutableLiveData<String>()
    private var password = MutableLiveData<String>()

    fun getEmail() = email as LiveData<String>

    fun getUserName() = userName as LiveData<String>

    fun getPassword() = password as LiveData<String>

    fun setEmail(email: String){
        this.email.value = email
    }

    fun setUserName(userName: String){
        this.userName.value = userName
    }

    fun setPassword(password: String){
        this.password.value = password
    }

    fun buildLoginModel(email: String, password: String) = LoginModel(email = email, password = password)

    fun buildLoginRequest(email: String, password: String) = RequestLogin(email = email, password = password)
}