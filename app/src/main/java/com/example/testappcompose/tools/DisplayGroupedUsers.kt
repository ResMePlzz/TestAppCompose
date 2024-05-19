package com.example.testappcompose.tools

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.testappcompose.domain.models.User

@Composable
fun DisplayGroupedUsers(usersGroupedByDate: Map<String, List<User>>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        usersGroupedByDate.forEach { (date, users) ->
            Text(
                text = "$date",
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(vertical = 8.dp)
            )
            Column(horizontalAlignment = Alignment.Start) {
                users.forEach { user ->
                    user.name.forEach { name->
                        Text(text = name)
                    }
                }
            }
        }
    }
}