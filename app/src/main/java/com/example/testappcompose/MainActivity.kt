package com.example.testappcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.compose.rememberNavController
import com.example.testappcompose.navigation.MyNavHost
import com.example.testappcompose.presentation.MainScreenViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val viewModel:MainScreenViewModel by viewModels()
            val navigate = rememberNavController()

            MyNavHost(navigator = navigate, mainScreenViewModel = viewModel)

        }
    }
}

