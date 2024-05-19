package com.example.testappcompose.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.testappcompose.domain.models.User
import com.example.testappcompose.navigation.AllScreen
import com.example.testappcompose.tools.ButtonBack
import com.example.testappcompose.tools.DisplayGroupedUsers
import com.example.testappcompose.tools.formatDateTimeToDate


@Composable
fun MyShoppingScreen(navigator:NavHostController) {

    val originalUsers  = listOf(
        User(date = "2022-09-10T21:55:33Z", name = listOf("123", "321")),
        User(date = "2022-09-10T21:50:33Z", name = listOf("1234", "4321")),
        User(date = "2022-09-08T01:55:33Z", name = listOf("12345", "54321")),
        User(date = "2022-09-07T21:55:33Z", name = listOf("123456", "654321")),
        User(date = "2022-09-07T11:55:33Z", name = listOf("1234567", "7654321"))
    )

    val mapUsers = originalUsers.groupBy {
        formatDateTimeToDate(dateTimeString = it.date)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color(0xFF3E3957),
                        Color(0xFF2B2646)
                    )
                )
            ),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {
        ButtonBack() {
            navigator.navigate(AllScreen.MainScreen.route)
        }

        Spacer(modifier = Modifier.height(20.dp))

        Column(
            modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            DisplayGroupedUsers(usersGroupedByDate = mapUsers)
            }
        }

    }





