package com.example.practica5

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ActivityMain2 : AppCompatActivity() {  // Convención de nombres en CamelCase para clases
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Referencias al botón y al TextView
        val btnShowInfo: Button = findViewById(R.id.btnShowInfo)
        val tvInfo: TextView = findViewById(R.id.tvInfo)

        // Recuperar los datos de la actividad anterior
        val usuario = intent.getStringExtra("USER_NAME")
        val edad = intent.getStringExtra("USER_AGE")
        val pass = intent.getStringExtra("USER_PASS")

        // Configurar el listener para el botón
        btnShowInfo.setOnClickListener {
            // Mostrar la información en el TextView
            val info = "Hola, $usuario, " +
                    "tu edad es: $edad " +
                    "y tu contraseña es: $pass"
            tvInfo.text = info
        }
    }
}


