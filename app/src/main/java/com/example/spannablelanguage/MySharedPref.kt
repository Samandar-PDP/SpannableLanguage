package com.example.spannablelanguage

import android.content.Context
import android.content.SharedPreferences

class MySharedPref(context: Context) {
    private val sharedPref: SharedPreferences =
        context.getSharedPreferences("MyPref", Context.MODE_PRIVATE)

    fun saveLanguage(language: String) {
        val editor = sharedPref.edit()
        editor.putString("lan", language)
        editor.apply()
    }

    fun getLanguage(): String {
        return sharedPref.getString("lan", "en") ?: "en"
    }
}