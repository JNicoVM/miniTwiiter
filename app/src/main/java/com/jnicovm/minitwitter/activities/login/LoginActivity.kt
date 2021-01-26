package com.jnicovm.minitwitter.activities.login

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.jnicovm.minitwitter.activities.signup.SignupActivity
import com.jnicovm.minitwitter.databinding.ActivityLoginBinding

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        initializeUi()
    }

    private fun initializeUi(){
        val factory = InjectorUtils.provideLoginViewModelFactory()
        val viewModel = ViewModelProvider(this, factory)
                .get(LoginViewModel::class.java)
        viewModel.getEmail().observe(this, Observer { email ->
            binding.etEmailLogin.setText(email)
        })
        viewModel.getPassword().observe(this, Observer { password ->
            binding.etPasswordLogin.setText(password)
        })
        binding.btnLogin.setOnClickListener {
            viewModel.setEmail(binding.etEmailLogin.text.toString())
        }
        binding.tvDontHaveAccount.setOnClickListener {
            SignupActivity.startActivity(this)
            finish()
        }
    }
}