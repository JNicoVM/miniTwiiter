package com.jnicovm.minitwitter.activities.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.jnicovm.minitwitter.dao.LoginDao
import com.jnicovm.minitwitter.models.request.RequestLogin
import com.jnicovm.minitwitter.models.response.ResponseLogin
import com.jnicovm.minitwitter.repository.AccountRepository
import com.jnicovm.minitwitter.repository.LoginRepository
import com.jnicovm.minitwitter.useCases.LoginUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class LoginViewModel(private val loginUseCase: LoginUseCase): ViewModel(){

    fun getEmail() = loginUseCase.getEmail()

    fun setEmail(email: String) = loginUseCase.setEmail("$email sending...")

    fun getPassword() = loginUseCase.getPassword()

    fun setPassword(password: String) = loginUseCase.setPassword(password)

    fun buildLoginModel(email: String, password: String) = loginUseCase.buildLoginModel(email, password)

    fun buildLoginRequest(email: String, password: String) = loginUseCase.buildLoginRequest(email, password)

    private val disposable = CompositeDisposable()

    private val _loginValues: MutableLiveData<ResponseLogin> = MutableLiveData()
    val loginValues: LiveData<ResponseLogin> get() = _loginValues

    fun perfomLogin() {
        disposable.add(
            loginUseCase.invoke().subscribe {
                _loginValues.value = Gson().fromJson(it, ResponseLogin::class.java)
            }
        )
    }

}