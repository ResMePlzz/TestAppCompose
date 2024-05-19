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
fun ValidationFieldWithNumber(
    placeholder: String,
    mainScreenViewModel: MainScreenViewModel,
    value: String,
    isError: Boolean,
    bottomHint: String,
    bottomErrorHint: String,
    onValueChange: (String) -> Unit,

) {
    val state = mainScreenViewModel.regScreenState

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
            border = BorderStroke(width = 1.dp, color = if (isError)Color.Red else Color.Gray),
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
                    focusedTextColor =  if (isError)Color.Red else Color.Gray,
                    focusedBorderColor = Color.Transparent,
                    unfocusedTextColor =  if (isError)Color.Red else Color.Gray,
                    focusedContainerColor = Color.Transparent,
                    unfocusedBorderColor = Color.Transparent,
                    
                ),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(23.dp)
        ) {


            Text(
                text = if (isError) bottomErrorHint else bottomHint,
                color = if (isError){
                    Color.Red
                } else {
                    Color.Gray
                } ,
                modifier = Modifier.padding(start = 10.dp, top = 5.dp)
            )
        }

    }

}



//@Composable
//fun ValidatingTextField() {
//
//    var text by remember { mutableStateOf("") }
//    var errorText by remember { mutableStateOf("") }
//
//    Card(
//        modifier = Modifier
//            .fillMaxWidth()
//            .height(70.dp)
//            .padding(start = 12.dp, end = 12.dp),
//        colors = CardDefaults.cardColors(Color(0xFF262239))
//    ) {
//        TextField(
//            value = text,
//            onValueChange = {
//                text = it
//                errorText = if (it.isEmpty()) "Поле не может быть пустым" else ""
//            },
//            label = { Text("Введите текст") },
//            isError = errorText.isNotEmpty(),
//            singleLine = true,
//            modifier = Modifier.fillMaxWidth()
//        )
//
//        if (errorText.isNotEmpty()) {
//            Text(
//                text = errorText,
//                color = Color.Red,
//                modifier = Modifier.padding(start = 4.dp)
//            )
//        }
//    }
//}
//
//if (number.isBlank() || number.isEmpty()){
//    errorMessage = "Некорректные данные"
//    isValid = false
//}
//else if(number.length < 13){
//    errorMessage = "Некорректные данные"
//    isValid = false
//}