package com.jnicovm.minitwitter.activities.signup

import androidx.lifecycle.ViewModel
import com.jnicovm.minitwitter.repository.AccountRepository

class SignupViewModel(private val accountRepository: AccountRepository): ViewModel(){

    fun getEmail() = accountRepository.getEmail()

    fun setEmail(email: String) = accountRepository.setEmail(email)

    fun getPassword() = accountRepository.getPassword()

    fun setPassword(password: String) = accountRepository.setPassword(password)

    fun getUserName() = accountRepository.getUserName()

    fun setUserName(userName: String) = accountRepository.setUserName(userName)

    fun buildAccountModel(userName: String, email: String, password: String) = accountRepository.buildAccountModel(userName, email, password)



}