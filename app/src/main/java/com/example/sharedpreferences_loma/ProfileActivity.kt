package com.example.sharedpreferences_loma

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat

class ProfileActivity : AppCompatActivity() {

    private lateinit var preferencesManager: PreferencesManager
    private lateinit var etName: EditText
    private lateinit var etAge: EditText
    private lateinit var etEmail: EditText
    private lateinit var btnSave: Button
    private lateinit var btnLoad: Button
    private lateinit var profileLayout: ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        preferencesManager = PreferencesManager(this)

        initViews()
        setupListeners()
        applyTheme()
    }

    private fun initViews() {
        etName = findViewById(R.id.etName)
        etAge = findViewById(R.id.etAge)
        etEmail = findViewById(R.id.etEmail)
        btnSave = findViewById(R.id.btnSave)
        btnLoad = findViewById(R.id.btnLoad)
        profileLayout = findViewById(R.id.profileLayout)
    }

    private fun setupListeners() {
        btnSave.setOnClickListener {
            saveProfile()
        }

        btnLoad.setOnClickListener {
            loadProfile()
        }
    }

    private fun saveProfile() {
        val name = etName.text.toString().trim()
        val age = etAge.text.toString().trim()
        val email = etEmail.text.toString().trim()

        if (name.isEmpty() || age.isEmpty() || email.isEmpty()) {
            Toast.makeText(this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show()
            return
        }

        preferencesManager.saveUserProfile(name, age, email)
        Toast.makeText(this, "Perfil guardado exitosamente", Toast.LENGTH_SHORT).show()
    }

    private fun loadProfile() {
        val name = preferencesManager.getUserName()
        val age = preferencesManager.getUserAge()
        val email = preferencesManager.getUserEmail()

        if (name.isEmpty() && age.isEmpty() && email.isEmpty()) {
            Toast.makeText(this, "No hay datos guardados", Toast.LENGTH_SHORT).show()
            return
        }

        etName.setText(name)
        etAge.setText(age)
        etEmail.setText(email)

        Toast.makeText(this, "Datos cargados", Toast.LENGTH_SHORT).show()
    }

    private fun applyTheme() {
        val isDarkMode = preferencesManager.isDarkMode()

        if (isDarkMode) {
            // Modo oscuro
            profileLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.dark_background))
            etName.setTextColor(ContextCompat.getColor(this, R.color.dark_text))
            etAge.setTextColor(ContextCompat.getColor(this, R.color.dark_text))
            etEmail.setTextColor(ContextCompat.getColor(this, R.color.dark_text))
        } else {
            // Modo claro
            profileLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.light_background))
            etName.setTextColor(ContextCompat.getColor(this, R.color.light_text))
            etAge.setTextColor(ContextCompat.getColor(this, R.color.light_text))
            etEmail.setTextColor(ContextCompat.getColor(this, R.color.light_text))
        }
    }
}