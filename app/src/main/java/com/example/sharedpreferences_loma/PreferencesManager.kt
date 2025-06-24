package com.example.sharedpreferences_loma

import android.content.Context
import android.content.SharedPreferences

class PreferencesManager(context: Context) {

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("app_preferences", Context.MODE_PRIVATE)

    companion object {
        private const val VISIT_COUNT_KEY = "visit_count"
        private const val USER_NAME_KEY = "user_name"
        private const val USER_AGE_KEY = "user_age"
        private const val USER_EMAIL_KEY = "user_email"
        private const val DARK_MODE_KEY = "dark_mode"
    }

    // Contador de visitas
    fun incrementVisitCount() {
        val currentCount = getVisitCount()
        sharedPreferences.edit().putInt(VISIT_COUNT_KEY, currentCount + 1).apply()
    }

    fun getVisitCount(): Int {
        return sharedPreferences.getInt(VISIT_COUNT_KEY, 0)
    }

    fun resetVisitCount() {
        sharedPreferences.edit().putInt(VISIT_COUNT_KEY, 0).apply()
    }

    // Perfil de usuario
    fun saveUserProfile(name: String, age: String, email: String) {
        sharedPreferences.edit().apply {
            putString(USER_NAME_KEY, name)
            putString(USER_AGE_KEY, age)
            putString(USER_EMAIL_KEY, email)
            apply()
        }
    }

    fun getUserName(): String {
        return sharedPreferences.getString(USER_NAME_KEY, "") ?: ""
    }

    fun getUserAge(): String {
        return sharedPreferences.getString(USER_AGE_KEY, "") ?: ""
    }

    fun getUserEmail(): String {
        return sharedPreferences.getString(USER_EMAIL_KEY, "") ?: ""
    }

    // Modo oscuro
    fun setDarkMode(isDarkMode: Boolean) {
        sharedPreferences.edit().putBoolean(DARK_MODE_KEY, isDarkMode).apply()
    }

    fun isDarkMode(): Boolean {
        return sharedPreferences.getBoolean(DARK_MODE_KEY, false)
    }
}