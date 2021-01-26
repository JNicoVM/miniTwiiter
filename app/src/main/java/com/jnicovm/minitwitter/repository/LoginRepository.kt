package com.jnicovm.minitwitter.repository

import com.jnicovm.minitwitter.dao.AccountDao
import com.jnicovm.minitwitter.dao.LoginDao
import com.jnicovm.minitwitter.data.RemoteLoginDataSource
import com.jnicovm.minitwitter.models.request.RequestLogin
import javax.inject.Inject

class LoginRepository @Inject constructor(
    private val remoteLoginDataSource: RemoteLoginDataSource,
    private val loginDao: LoginDao
){
    fun getEmail() = loginDao.getEmail()

    fun setEmail(email: String) = loginDao.setEmail(email)

    fun getUserName()  = loginDao.getUserName()

    fun setUserName(userName: String) = loginDao.setUserName(userName)

    fun getPassword()  = loginDao.getPassword()

    fun setPassword(passWord: String) = loginDao.setPassword(passWord)

    fun buildAccountModel(email: String, userName: String, password: String) = loginDao.buildAccountModel(email, userName, password)

    fun perfomLogin(requestLogin: RequestLogin) = remoteLoginDataSource.perfomLogin(requestLogin)
}