package com.example.prakashalay.data.models.api.account.changepassword

data class SendPassword(
    val newpassword: String = "", // password
    val oldpassword: String = "" // password
)