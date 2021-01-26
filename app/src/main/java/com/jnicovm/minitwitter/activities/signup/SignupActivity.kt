package com.jnicovm.minitwitter.activities.signup

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.jnicovm.minitwitter.databinding.ActivitySignupBinding
import com.jnicovm.minitwitter.activities.login.LoginActivity

class SignupActivity : AppCompatActivity() {

    companion object {
        fun startActivity(context: Context) {
            val intent = Intent(
                context,
                SignupActivity::class.java
            )
            context.startActivity(intent)
        }
    }

    private lateinit var binding: ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        initializeUi()
    }

    private fun initializeUi() {
        val factory = InjectorUtils.provideSignupViewModelFactory()
        val viewModel = ViewModelProvider(this, factory)
            .get(SignupViewModel::class.java)
        viewModel.getEmail().observe(this, Observer { email ->
            binding.etEmailSignup.setText(email)
        })
        viewModel.getPassword().observe(this, Observer { password ->
            binding.etPasswordSignup.setText(password)
        })
        viewModel.getUserName().observe(this, Observer { userName ->
            binding.etUsernameSignup.setText(userName)
        })
        binding.btnSignup.setOnClickListener {
            viewModel.setEmail(binding.etEmailSignup.text.toString())
            viewModel.setPassword(binding.etPasswordSignup.text.toString())
            viewModel.setUserName(binding.etUsernameSignup.text.toString())
            viewModel.buildAccountModel(
                binding.etUsernameSignup.text.toString(),
                binding.etEmailSignup.text.toString(),
                binding.etPasswordSignup.text.toString()
            )
        }
        binding.tvAlreadyAccount.setOnClickListener {
            LoginActivity.startActivity(this)
            finish()
        }
    }
}