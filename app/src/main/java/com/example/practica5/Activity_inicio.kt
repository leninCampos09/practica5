package com.example.practica5

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Activity_inicio : AppCompatActivity() {

    private lateinit var txtUsuario: EditText
    private lateinit var txtEdad: EditText
    private lateinit var txtPass: EditText
    private lateinit var btnEnviar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_inicio)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Inicializar los EditText y el Button
        txtUsuario = findViewById(R.id.txtUsuario)
        txtEdad = findViewById(R.id.txtEdad)
        txtPass = findViewById(R.id.txtPass)
        btnEnviar = findViewById(R.id.btnEnviar)

        // Configurar el botón para que envíe los datos a otra actividad al hacer clic
        btnEnviar.setOnClickListener {
            val usuario = txtUsuario.text.toString()
            val edad = txtEdad.text.toString()
            val password = txtPass.text.toString()

            // Resetear el borde de todos los campos
            resetBorders()

            if (usuario.isNotEmpty() && edad.isNotEmpty() && password.isNotEmpty()) {
                // Crear un Intent para iniciar la segunda actividad
                val intent = Intent(this, ActivityMain2::class.java).apply {
                    putExtra("USER_NAME", usuario)
                    putExtra("USER_AGE", edad)
                    putExtra("USER_PASS", password)
                }
                startActivity(intent)
            } else {
                // Mostrar un Toast si hay campos vacíos
                Toast.makeText(this, "No pueden haber campos vacíos", Toast.LENGTH_SHORT).show()

                // Enfocar el primer campo vacío y aplicar borde rojo
                when {
                    usuario.isEmpty() -> {
                        txtUsuario.requestFocus()
                        txtUsuario.background = getDrawable(R.drawable.border_red)
                    }
                    edad.isEmpty() -> {
                        txtEdad.requestFocus()
                        txtEdad.background = getDrawable(R.drawable.border_red)
                    }
                    password.isEmpty() -> {
                        txtPass.requestFocus()
                        txtPass.background = getDrawable(R.drawable.border_red)
                    }
                }
            }
        }
    }

    private fun resetBorders() {
        // Restaurar el borde original para todos los campos
        txtUsuario.background = getDrawable(R.drawable.border_normal)
        txtEdad.background = getDrawable(R.drawable.border_normal)
        txtPass.background = getDrawable(R.drawable.border_normal)
    }
}






