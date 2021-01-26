package com.jnicovm.minitwitter.dao

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.jnicovm.minitwitter.models.AccountModel
import com.jnicovm.minitwitter.models.LoginModel

class LoginDao {

    private var email = MutableLiveData<String>()
    private var userName = MutableLiveData<String>()
    private var password = MutableLiveData<String>()

    init { }

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

    fun buildAccountModel(email: String, userName: String, password: String) =  AccountModel(email, userName, password)

    fun buildLoginModel(email: String, password: String) = LoginModel(email = email, password = password)
}