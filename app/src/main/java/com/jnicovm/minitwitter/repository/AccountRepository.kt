package com.jnicovm.minitwitter.repository

import com.jnicovm.minitwitter.dao.AccountDao

class AccountRepository private constructor(private val accountDao: AccountDao){

    fun getEmail() = accountDao.getEmail()

    fun setEmail(email: String) = accountDao.setEmail(email)

    fun getUserName()  = accountDao.getUserName()

    fun setUserName(userName: String) = accountDao.setUserName(userName)

    fun getPassword()  = accountDao.getPassword()

    fun setPassword(passWord: String) = accountDao.setPassword(passWord)

    fun buildAccountModel(email: String, userName: String, password: String) = accountDao.buildAccountModel(email, userName, password)

    fun buildLoginModel(email: String, password: String) = accountDao.buildLoginModel(email, password)


    companion object{
        @Volatile private var instance: AccountRepository? = null

        fun getInstance(accountDao: AccountDao)=
            instance
                    ?: synchronized(this){
                instance
                    ?: AccountRepository(
                        accountDao
                    )
                        .also { instance = it }
            }
    }
}