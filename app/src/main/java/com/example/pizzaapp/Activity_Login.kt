package com.example.pizzaapp

import android.accounts.Account
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.pizzaapp.client.RetrofitClient
import com.example.pizzaapp.response.account.LoginResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class Activity_Login : AppCompatActivity() {
    companion object {
        var name = "Dicky Firmansyah"
        var email = "dickyfirmansyah@students.amikom.ac.id"
        var password = "123456"
        var level = "Cashier"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
//        Login Validation -> if true call activity Account
        val txtUsername : EditText = findViewById(R.id.editTextUsername)
        val txtPassword : EditText = findViewById(R.id.editTextPass)
        val btnLogin : Button = findViewById(R.id.buttonLogin)
        btnLogin.setOnClickListener {
            var username = txtUsername.text.toString().trim()
            var password = txtPassword.text.toString().trim()
            if (username.isEmpty()) {
                txtUsername.error = "Email required"
                txtUsername.requestFocus()
                return@setOnClickListener
            } else if (password.isEmpty()) {
                txtPassword.error = "Password required"
                txtPassword.requestFocus()
                return@setOnClickListener
            }
            RetrofitClient.instance.postLogin(username, password).enqueue(
                object : Callback<LoginResponse> {
                    override fun onResponse(
                        call: Call<LoginResponse>, response: Response<LoginResponse>) {

                        val account = response.body()
                        if (account?.success == true) {
                            Toast.makeText(this@Activity_Login, account?.message.toString(), Toast.LENGTH_SHORT).show()
                            val intentLogin = Intent(this@Activity_Login, Home_Activity::class.java)
                            startActivity(intentLogin)
                        } else {
                            Toast.makeText(this@Activity_Login, account?.message.toString(), Toast.LENGTH_SHORT).show()
                        }
                    }
                    override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                        Toast.makeText(this@Activity_Login, t.message, Toast.LENGTH_SHORT).show()
                    }
                })
        }
    }
}