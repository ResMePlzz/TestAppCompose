package com.example.testappcompose.tools

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

fun gradientBackground(){
    val gradientBrush = Brush.linearGradient(
        colors = listOf(
            Color(0xFF8A2BE2),
            Color(0xFF4B0082)
        ))
}