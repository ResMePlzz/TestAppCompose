package com.example.testappcompose.domain.screen_states

data class RegistrationScreenState(
    val numberCard: String = "",
    val code: String = "",
    val firstName: String = "",
    val lastName: String = "",
    val numberCardError: Boolean = false,
    val codeError:Boolean = false,
    val firstNameError:Boolean = false,
    val lastNameError:Boolean = false,
    val enableButton:Boolean = false


) {



}



