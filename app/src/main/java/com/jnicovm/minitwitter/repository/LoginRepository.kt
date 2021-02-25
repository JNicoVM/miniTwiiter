package com.jnicovm.minitwitter.repository

import com.jnicovm.minitwitter.dao.LoginDao
import com.jnicovm.minitwitter.data.RemoteLoginDataSource
import com.jnicovm.minitwitter.models.request.RequestLogin

class LoginRepository (
    private val remoteLoginDataSource: RemoteLoginDataSource,
    private val loginDao: LoginDao
){
    fun getEmail() = loginDao.getEmail()

    fun setEmail(email: String) = loginDao.setEmail(email)

    fun getUserName()  = loginDao.getUserName()

    fun setUserName(userName: String) = loginDao.setUserName(userName)

    fun getPassword()  = loginDao.getPassword()

    fun setPassword(passWord: String) = loginDao.setPassword(passWord)

    fun buildLoginModel(email: String,  password: String) = loginDao.buildLoginModel(email, password)

    fun buildLoginRequest(email: String, password: String) = loginDao.buildLoginRequest(email, password)

    fun perfomLogin(requestLogin: RequestLogin) = remoteLoginDataSource.perfomLogin(requestLogin)
}