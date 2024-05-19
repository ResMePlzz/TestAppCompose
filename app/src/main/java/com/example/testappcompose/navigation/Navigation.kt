package com.example.testappcompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.testappcompose.presentation.MainScreen
import com.example.testappcompose.presentation.MainScreenViewModel
import com.example.testappcompose.presentation.MyShoppingScreen
import com.example.testappcompose.presentation.RegistrationScreen

sealed class AllScreen(val route: String) {

    object MainScreen : AllScreen(
        route = "MainScreen"
    )

    object RegistrationScreen : AllScreen(
        route = "RegistrationScreen"
    )

    object MyShoppingScreen : AllScreen(
        route = "MyShoppingScreen"
    )



}

@Composable
fun MyNavHost(
    navigator: NavHostController,
    mainScreenViewModel: MainScreenViewModel
) {
    NavHost(navController = navigator, startDestination = AllScreen.MainScreen.route) {
        composable(route = AllScreen.MainScreen.route){
             MainScreen(navigator)
        }
        composable(route = AllScreen.RegistrationScreen.route){
            RegistrationScreen(viewModel = mainScreenViewModel,navigator)
        }
        composable(route = AllScreen.MyShoppingScreen.route){
            MyShoppingScreen(navigator)
        }
    }
}