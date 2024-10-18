package com.example.pizzaapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

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
            if (txtUsername.text.toString().equals(name) && txtPassword.text.toString().equals(password)) {
                val pindahAccount = Intent(this, Home_Activity::class.java)
                startActivity(pindahAccount)
            }else {
                Toast.makeText(this, "Username atau Password salah", Toast.LENGTH_SHORT).show()
            }
        }
    }
}