package com.jnicovm.minitwitter.activities.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.jnicovm.minitwitter.activities.signup.SignupActivity
import com.jnicovm.minitwitter.databinding.ActivityLoginBinding
import com.jnicovm.minitwitter.di.LoginComponent
import com.jnicovm.minitwitter.di.LoginModule
import com.jnicovm.minitwitter.utilities.app
import com.jnicovm.minitwitter.utilities.getViewModel
import com.jnicovm.minitwitter.utilities.showLongToast

class LoginActivity : AppCompatActivity() {

    companion object {
        fun startActivity(context: Context) {
            val intent = Intent(
                context,
                LoginActivity::class.java
            )
            context.startActivity(intent)
        }
    }

    //Binding
    private lateinit var binding: ActivityLoginBinding
    private lateinit var loginComponent: LoginComponent

    private val loginViewModel: LoginViewModel by lazy {
       getViewModel { loginComponent.loginViewModel }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        initializeUi()
    }

    private fun initializeUi(){
        loginComponent = app.component.inject(LoginModule())
        loginViewModel.getEmail().observe(this, Observer { email ->
            binding.etEmailLogin.setText(email)
        })
        loginViewModel.getPassword().observe(this, Observer { password ->
            binding.etPasswordLogin.setText(password)
        })
        binding.btnLogin.setOnClickListener {
            loginViewModel.setEmail(binding.etEmailLogin.text.toString())
            loginViewModel.setPassword(binding.etPasswordLogin.text.toString())
            loginViewModel.perfomLogin()

            loginViewModel.buildLoginRequest(loginViewModel.getEmail().value?:"",
                loginViewModel.getPassword().value?:"")
        }
        binding.tvDontHaveAccount.setOnClickListener {
            SignupActivity.startActivity(this)
            finish()
        }
        loginViewModel.loginValues.observe(this, Observer {
            showLongToast("Se ha intentado loguear el usuario ${it.username}")
        })
    }
}