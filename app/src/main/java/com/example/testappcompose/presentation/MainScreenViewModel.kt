package com.example.testappcompose.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.testappcompose.domain.screen_states.RegistrationScreenState

class MainScreenViewModel : ViewModel() {

    var regScreenState by mutableStateOf<RegistrationScreenState?>(null)
        private set

    fun changeRegScreenState(newState:RegistrationScreenState){
        regScreenState = newState
    }


}