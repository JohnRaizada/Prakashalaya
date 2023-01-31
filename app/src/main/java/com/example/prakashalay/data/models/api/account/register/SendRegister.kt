package com.example.prakashalay.data.models.api.account.register

data class SendRegister(
    val username: String = "",
    val name: String = "",
    val gender: String = "",
    val mobile_number: String = "",
    val date_of_birth: String = "",
    val password: String = "",
    val email_address: String = "",
    val city: String = "",
    val country: String = ""
)
