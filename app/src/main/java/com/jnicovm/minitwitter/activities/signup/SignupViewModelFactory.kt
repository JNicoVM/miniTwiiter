package com.jnicovm.minitwitter.activities.signup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jnicovm.minitwitter.repository.AccountRepository


class SignupViewModelFactory(private val accountRepository: AccountRepository)
    :ViewModelProvider.NewInstanceFactory(){

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SignupViewModel(accountRepository) as T
    }
}