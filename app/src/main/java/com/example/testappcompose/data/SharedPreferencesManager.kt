package com.example.testappcompose.data

import android.content.Context
import android.content.SharedPreferences

class SharedPreferencesManager(context: Context) {
    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("my_preference", Context.MODE_PRIVATE)


    var firstName: String
        get() = sharedPreferences.getString("firstName", "") ?: ""
        set(value) {
            sharedPreferences.edit().putString("firstName", value).apply()
        }

    var lastName: String
        get() = sharedPreferences.getString("lastName", "") ?: ""
        set(value) {
            sharedPreferences.edit().putString("lastName", value).apply()
        }
}