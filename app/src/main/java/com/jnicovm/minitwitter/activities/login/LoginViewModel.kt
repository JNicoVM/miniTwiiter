package com.jnicovm.minitwitter.activities.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jnicovm.minitwitter.dao.LoginDao
import com.jnicovm.minitwitter.models.request.RequestLogin
import com.jnicovm.minitwitter.models.response.ResponseLogin
import com.jnicovm.minitwitter.repository.AccountRepository
import com.jnicovm.minitwitter.repository.LoginRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class LoginViewModel(private val loginRepository: LoginRepository,
private val loginDao: LoginDao): ViewModel(){

//    fun getEmail() = accountRepository.getEmail()
//
//    fun setEmail(email: String) = accountRepository.setEmail("$email sending...")
//
//    fun getPassword() = accountRepository.getPassword()
//
//    fun setPassword(password: String) = accountRepository.setPassword(password)
//
//    fun buildLoginModel(email: String, password: String) = accountRepository.buildLoginModel(email, password)

    private val disposable = CompositeDisposable()

    //local values

    val user: MutableLiveData<String> = MutableLiveData()
    val email: MutableLiveData<String> = MutableLiveData()
    private val _loginValues: MutableLiveData<ResponseLogin> = MutableLiveData()
    val loginValues: LiveData<ResponseLogin> get() = _loginValues

    fun perfomLogin(requestLogin: RequestLogin) {
        disposable.add(
            loginRepository.perfomLogin(requestLogin)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe {
                    _loginValues.value = it
                }
        )

    }

}