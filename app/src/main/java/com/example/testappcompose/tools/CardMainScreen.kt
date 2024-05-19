package com.example.testappcompose.tools

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun CardMainScreen(typeCardMain: TypeCardMain, height: Dp = 70.dp, onClick: () -> Unit = {}) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .height(height)
            .padding(start = 12.dp, end = 12.dp),
        colors = CardDefaults.cardColors(Color(0xFF262239))
    ) {
        Row(
            modifier = Modifier.fillMaxSize().padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            when (typeCardMain) {
                TypeCardMain.MY_PAYMENT -> {
                    Row {
                        OutlinedButton(
                            onClick = { onClick() },
                            modifier = Modifier
                                .padding(10.dp)
                                .align(Alignment.CenterVertically)
                                .size(40.dp),
                            border = BorderStroke(0.dp, Color.Blue),
                            contentPadding = PaddingValues(0.dp),
                            shape = CircleShape,
                            colors = ButtonDefaults.buttonColors(Color(0xFF25027F))
                        ) {
                            Text(
                                text = "•ON•",
                                fontWeight = FontWeight.Bold,
                                color = Color.Red,
                                fontSize = 17.sp,
                            )

                        }
                    }
                    Icon(
                        imageVector = Icons.Filled.KeyboardArrowRight,
                        contentDescription = "",
                        modifier = Modifier.padding(end = 10.dp),
                        tint = Color.White

                    )



                }


                TypeCardMain.EMAIL -> {
                    Row {

                        Text(
                            text = "E-mail",
                            fontWeight = FontWeight.Medium,
                            color = Color.Gray,
                            fontSize = 17.sp,
                        )


                    }


                    Row {

                        Column(modifier = Modifier) {
                            Text(
                                text = "kursantik341@gmail.com",
                                fontWeight = FontWeight.Medium,
                                color = Color.Gray,
                                fontSize = 17.sp,
                            )
                            Text(
                                text = "Необходимо потвердить",
                                fontWeight = FontWeight.Medium,
                                color = Color.Red,
                                fontSize = 12.sp,
                            )


                        }
                        Icon(
                            imageVector = Icons.Filled.KeyboardArrowRight,
                            contentDescription = "",
                            modifier = Modifier.padding(end = 10.dp),
                            tint = Color.White

                        )
                    }
                }

                TypeCardMain.ENTER_BIO -> {
                    Row {

                        Text(
                            text = "Вход по биометрии",
                            fontWeight = FontWeight.Medium,
                            color = Color.Gray,
                            fontSize = 17.sp,
                        )

                    }

                    Switcher()


                }
                TypeCardMain.CHANGE_4 -> {
                    Row {

                        Text(
                            text = "Сменить 4-х значений",
                            fontWeight = FontWeight.Medium,
                            color = Color.Gray,
                            fontSize = 17.sp,
                        )

                    }

                    Icon(
                        imageVector = Icons.Filled.KeyboardArrowRight,
                        contentDescription = "",
                        modifier = Modifier.padding(end = 10.dp),
                        tint = Color.White

                    )

                }
                TypeCardMain.REGISTRATION -> {
                    Row {

                        Text(
                            text = "Регистрация для клиента банка",
                            fontWeight = FontWeight.Medium,
                            color = Color.Gray,
                            fontSize = 17.sp,
                        )

                    }

                    Icon(
                        imageVector = Icons.Filled.KeyboardArrowRight,
                        contentDescription = "",
                        modifier = Modifier.padding(end = 10.dp),
                        tint = Color.White

                    )

                }
                TypeCardMain.LANGUAGE -> {
                    Row {

                        Text(
                            text = "Язык",
                            fontWeight = FontWeight.Medium,
                            color = Color.Gray,
                            fontSize = 17.sp,
                        )
                    }
                    Row {

                        Text(
                            text = "русский",
                            fontWeight = FontWeight.Medium,
                            color = Color.Gray,
                            fontSize = 17.sp,
                        )
                        Icon(
                            imageVector = Icons.Filled.KeyboardArrowRight,
                            contentDescription = "",
                            modifier = Modifier
                                .padding(end = 10.dp),
                            tint = Color.White,


                            )


                    }
                }
            }

        }
    }
}

enum class TypeCardMain() {
    MY_PAYMENT, EMAIL, ENTER_BIO, CHANGE_4, REGISTRATION, LANGUAGE
}