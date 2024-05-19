package com.example.testappcompose.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.testappcompose.data.SharedPreferencesManager
import com.example.testappcompose.navigation.AllScreen
import com.example.testappcompose.tools.ButtonBack
import com.example.testappcompose.tools.CardMainScreen
import com.example.testappcompose.tools.TypeCardMain


@Composable
fun MainScreen(navigator:NavHostController) {

    val sharedPreferencesManager = SharedPreferencesManager(LocalContext.current)

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

        ButtonBack {
        }
        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = sharedPreferencesManager.firstName.ifEmpty { "art" },
            modifier = Modifier.padding(8.dp),
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
        Spacer(modifier = Modifier.height(2.dp))
        Row(modifier = Modifier, verticalAlignment = Alignment.Bottom) {
            Text(
                text = sharedPreferencesManager.lastName.ifEmpty { "art" },
                modifier = Modifier.padding(8.dp),
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Icon(
                imageVector = Icons.Filled.Edit,
                contentDescription = "",
                modifier = Modifier.padding(bottom = 13.dp),
                tint = Color.Gray
            )
        }

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = "+79243014334",
            modifier = Modifier.padding(8.dp),
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = "Мои покупки".uppercase(),
            modifier = Modifier.padding(8.dp),
            fontSize = 15.sp,
            fontWeight = FontWeight.Normal,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(2.dp))

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CardMainScreen(typeCardMain = TypeCardMain.MY_PAYMENT) {
                navigator.navigate(AllScreen.MyShoppingScreen.route)
            }
            Spacer(modifier = Modifier.height(10.dp))

            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Start) {
                Text(
                    text = "Мои настройки".uppercase(),
                    modifier = Modifier.padding(8.dp),
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.Gray
                )
            }
            CardMainScreen(typeCardMain = TypeCardMain.EMAIL, height = 80.dp)
            Spacer(modifier = Modifier.height(10.dp))
            CardMainScreen(typeCardMain = TypeCardMain.ENTER_BIO)
            Spacer(modifier = Modifier.height(10.dp))
            CardMainScreen(typeCardMain = TypeCardMain.CHANGE_4)
            Spacer(modifier = Modifier.height(10.dp))
            CardMainScreen(typeCardMain = TypeCardMain.REGISTRATION){
                navigator.navigate(AllScreen.RegistrationScreen.route)
            }
            Spacer(modifier = Modifier.height(10.dp))
            CardMainScreen(typeCardMain = TypeCardMain.LANGUAGE)


        }


    }
}




