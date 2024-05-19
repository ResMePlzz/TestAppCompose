package com.example.testappcompose.tools

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.testappcompose.presentation.MainScreenViewModel

@Composable
fun ValidationFieldWithString(
    placeholder: String,
    value: String,
    isError: Boolean,
    mainScreenViewModel: MainScreenViewModel,
    bottomErrorHint: String,
    bottomHint: String,
    onValueChange: (String) -> Unit,
) {

    Spacer(modifier = Modifier.height(10.dp))

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .padding(start = 12.dp, end = 12.dp),
            border = BorderStroke(width = 1.dp, color = if (isError) Color.Red else Color.Gray),
            colors = CardDefaults.cardColors(Color(0xFF262239))
        ) {


            OutlinedTextField(
                value = value,
                onValueChange = {
                    onValueChange(it)
                },
                placeholder = { Text(text = placeholder, color = Color.Gray) },
                singleLine = true,
                modifier = Modifier.fillMaxSize(),
                shape = ShapeDefaults.Small,
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = Color.Gray,
                    focusedBorderColor = Color.Transparent,
                    errorTextColor = Color.Red,
                    unfocusedTextColor = Color.Gray,
                    focusedContainerColor = Color.Transparent,
                    unfocusedBorderColor = Color.Transparent,
                ),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),

                )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(23.dp)
        ) {


            Text(
                text = if (isError) bottomErrorHint else bottomHint,
                color = if (isError) {
                    Color.Red
                } else {
                    Color.Gray
                },
                modifier = Modifier.padding(start = 10.dp, top = 5.dp)
            )
        }

    }

}