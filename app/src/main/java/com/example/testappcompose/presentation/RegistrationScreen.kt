package com.example.testappcompose.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.testappcompose.data.SharedPreferencesManager
import com.example.testappcompose.domain.screen_states.RegistrationScreenState
import com.example.testappcompose.navigation.AllScreen
import com.example.testappcompose.tools.ButtonBack
import com.example.testappcompose.tools.ValidationFieldWithNumber
import com.example.testappcompose.tools.ValidationFieldWithString


@Composable
fun RegistrationScreen(viewModel: MainScreenViewModel, navigator: NavHostController) {

    val sharedPreferencesManager = SharedPreferencesManager(LocalContext.current)
    val state = viewModel.regScreenState ?: RegistrationScreenState()




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
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = "Регистрация для клиентов банка", modifier = Modifier.padding(10.dp),
            fontSize = 35.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )

        Spacer(modifier = Modifier.height(8.dp))

        ValidationFieldWithNumber(
            placeholder = "Номер участиника",
            mainScreenViewModel = viewModel,
            value = state.numberCard,
            isError = state.numberCardError,
            bottomHint = "Номер из 16 цифр, который вы получили от банка",
            bottomErrorHint = "Неверные данные",

            ) {
            if (it.length < 17) {
                viewModel.changeRegScreenState(
                    state.copy(
                        numberCard = it,
                        numberCardError = it.length != 16,

                        )
                )
            }

        }
        Spacer(modifier = Modifier.height(0.dp))

        ValidationFieldWithNumber(
            placeholder = "Код",
            mainScreenViewModel = viewModel,
            value = state.code,
            isError = state.codeError,
            bottomHint = "Код который вы получили от банка",
            bottomErrorHint = "Неверные данные"
        ) {
            viewModel.changeRegScreenState(
                state.copy(
                    code = it,
                    codeError = it.isBlank()
                )
            )
        }
        ValidationFieldWithString(
            placeholder = "Имя",
            mainScreenViewModel = viewModel,
            value = state.firstName,
            isError = state.firstNameError,
            bottomHint = "Имя (на латинице как в загранпаспорте)",
            bottomErrorHint = "Имя (на латинице как в загранпаспорте)"
        ) {
            viewModel.changeRegScreenState(
                state.copy(
                    firstName = it,
                    firstNameError = it.isBlank()
                )
            )
        }
        ValidationFieldWithString(
            placeholder = "Фамилия",
            mainScreenViewModel = viewModel,
            value = state.lastName,
            isError = state.lastNameError,
            bottomHint = "Фамилия (на латинице как в загранпаспорте)",
            bottomErrorHint = "Фамилия (на латинице как в загранпаспорте)"
        ) {
            viewModel.changeRegScreenState(
                state.copy(
                    lastName = it,
                    lastNameError = it.isBlank()
                )
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(50.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            val text = buildAnnotatedString {
                append("Нажимая кнопку продолжить, вы соглашаетесь с ")
                withStyle(
                    style = SpanStyle(
                        textDecoration = TextDecoration.Underline,
                        color = Color.White
                    )
                ) {
                    append("условиями участия")
                }

            }
            Text(text = text, modifier = Modifier.padding(16.dp), color = Color.LightGray)

            Spacer(modifier = Modifier.height(10.dp))
            Button(
                onClick = {
                    sharedPreferencesManager.firstName = state.firstName
                    sharedPreferencesManager.lastName = state.lastName
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFCC3151),
                    disabledContainerColor = Color(0xFF86525D)
                ),
                shape = RoundedCornerShape(24.dp),
                enabled = !state.firstNameError
                        && !state.lastNameError
                        && !state.codeError
                        && !state.numberCardError
                        && state.firstName.isNotEmpty()
                        && state.lastName.isNotEmpty()
                        && state.code.isNotEmpty()
                        && state.numberCard.isNotEmpty(),
                modifier = Modifier
                    .width(380.dp)
                    .height(60.dp)
            ) {
                Text(
                    text = "Продолжить",
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )

            }

        }
    }
}