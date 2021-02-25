package com.jnicovm.minitwitter.useCases

import androidx.lifecycle.LiveData
import com.google.gson.JsonObject
import com.jnicovm.minitwitter.models.request.RequestLogin
import com.jnicovm.minitwitter.repository.LoginRepository
import io.reactivex.Observable

class LoginUseCase(private val loginRepository: LoginRepository){
    fun invoke() : Observable<JsonObject> =
         loginRepository.perfomLogin(RequestLogin(getEmail().value?:"", getPassword().value?:""))

    fun getEmail(): LiveData<String> =
        loginRepository.getEmail()

    fun getPassword(): LiveData<String> =
        loginRepository.getPassword()

    fun getUserName(): LiveData<String> =
        loginRepository.getUserName()

    fun setEmail(email: String){
        loginRepository.setEmail(email)
    }

    fun setPassword(password: String){
        loginRepository.setPassword(password)
    }

    fun setUserName(username: String){
        loginRepository.setUserName(username)
    }

    fun buildLoginModel(email: String, password: String) = loginRepository.buildLoginModel(email = email, password = password)

    fun buildLoginRequest(email: String, password: String) = loginRepository.buildLoginRequest(email = email, password = password)

}