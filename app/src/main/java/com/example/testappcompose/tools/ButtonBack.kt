package com.example.testappcompose.tools

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun ButtonBack(onClick: () -> Unit) {
    Button(
        onClick = { onClick() },
        modifier = Modifier
            .padding(start = 8.dp, top = 3.dp),
        contentPadding = PaddingValues(8.dp),
        elevation = ButtonDefaults.buttonElevation(8.dp),
        border = BorderStroke(2.dp, Color.Black),
        colors = ButtonDefaults.buttonColors(Color(0xFF3E3957))
    ) {
        Icon(imageVector = Icons.Filled.KeyboardArrowLeft, contentDescription = "")
        Text(text = "Назад")
    }
}