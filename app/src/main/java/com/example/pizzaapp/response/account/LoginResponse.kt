package com.example.pizzaapp.response.account

data class LoginResponse (
    val success: Boolean,
    val message: String,
    val `data`: Data
)