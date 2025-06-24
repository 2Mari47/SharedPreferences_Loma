package com.example.sharedpreferences_loma

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Switch
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    private lateinit var preferencesManager: PreferencesManager
    private lateinit var visitCountTextView: TextView
    private lateinit var resetButton: Button
    private lateinit var profileButton: Button
    private lateinit var darkModeSwitch: Switch
    private lateinit var mainLayout: ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        preferencesManager = PreferencesManager(this)

        initViews()
        setupListeners()
        applyTheme()
        updateVisitCount()
    }

    override fun onResume() {
        super.onResume()
        applyTheme()
    }

    private fun initViews() {
        visitCountTextView = findViewById(R.id.tvVisitCount)
        resetButton = findViewById(R.id.btnReset)
        profileButton = findViewById(R.id.btnProfile)
        darkModeSwitch = findViewById(R.id.switchDarkMode)
        mainLayout = findViewById(R.id.mainLayout)

        // Configurar el switch según la preferencia guardada
        darkModeSwitch.isChecked = preferencesManager.isDarkMode()
    }

    private fun setupListeners() {
        resetButton.setOnClickListener {
            preferencesManager.resetVisitCount()
            updateVisitCount()
        }

        profileButton.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }

        darkModeSwitch.setOnCheckedChangeListener { _, isChecked ->
            preferencesManager.setDarkMode(isChecked)
            applyTheme()
        }
    }

    private fun updateVisitCount() {
        // Incrementar contador al abrir la app
        preferencesManager.incrementVisitCount()
        val count = preferencesManager.getVisitCount()
        visitCountTextView.text = "Visitas: $count"
    }

    private fun applyTheme() {
        val isDarkMode = preferencesManager.isDarkMode()

        if (isDarkMode) {
            // Modo oscuro
            mainLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.dark_background))
            visitCountTextView.setTextColor(ContextCompat.getColor(this, R.color.dark_text))
        } else {
            // Modo claro
            mainLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.light_background))
            visitCountTextView.setTextColor(ContextCompat.getColor(this, R.color.light_text))
        }

        darkModeSwitch.isChecked = isDarkMode
    }
}