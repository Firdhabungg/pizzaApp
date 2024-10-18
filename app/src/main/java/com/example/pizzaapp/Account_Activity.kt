package com.example.pizzaapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.EditText
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Account_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_account)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
//set data
        val txtName:EditText = findViewById(R.id.editTextName)
        val txtEmail:EditText = findViewById(R.id.editTextEmail)
        val txtPassword:EditText = findViewById(R.id.editTextPassword)
        val txtLevel:EditText = findViewById(R.id.editTextTextLevel)

        txtName.setText(Activity_Login.name)
        txtEmail.setText(Activity_Login.email)
        txtPassword.setText(Activity_Login.password)
        txtLevel.setText(Activity_Login.level)

//        implicit intent
//       call dial number activity
        val dial : LinearLayout = findViewById(R.id.LinearLayoutCall)
        dial.setOnClickListener {
            val dialIntent : Intent = Uri.parse("tel:0895380187668").let {
                number -> Intent(Intent.ACTION_DIAL, number)
            }
            startActivity(dialIntent)
        }

//        call web page activity
        val web : LinearLayout = findViewById(R.id.LinearLayoutWebsite)
        web.setOnClickListener {
            val webIntent : Intent = Uri.parse("https://amikom.ac.id/").let {
                    webpage -> Intent(Intent.ACTION_VIEW, webpage)
            }
            startActivity(webIntent)
        }

//        call maps activity
        val map : LinearLayout = findViewById(R.id.LinearLayoutLocation)
        map.setOnClickListener {
            val mapIntent : Intent = Uri.parse("geo:0,0?q=Universitas+Amikom+Yogyakarta").let {
                    gmaps -> Intent(Intent.ACTION_VIEW, gmaps)
            }
            mapIntent.setPackage("com.google.android.apps.maps")
            startActivity(mapIntent)

        }
    }
}