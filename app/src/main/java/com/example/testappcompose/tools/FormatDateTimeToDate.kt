package com.example.testappcompose.tools

import androidx.compose.runtime.Composable
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter

@Composable
fun formatDateTimeToDate(dateTimeString: String): String {
    val inputFormatter = DateTimeFormatter.ISO_DATE_TIME
    val outputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
    val dateTime = OffsetDateTime.parse(dateTimeString, inputFormatter)
    return dateTime.format(outputFormatter)
}