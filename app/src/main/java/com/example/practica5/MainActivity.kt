package com.example.practica5

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {

    private lateinit var mytoolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()  // Si estás usando enableEdgeToEdge, asegúrate de que la dependencia está correctamente configurada
        setContentView(R.layout.activity_main)

        mytoolbar = findViewById(R.id.mytoolbar)
        setSupportActionBar(mytoolbar)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.mi_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.nav_activity -> {
                val i = Intent(this, Activity_inicio::class.java)
                startActivity(i)
                true
            }
            R.id.nav_logout -> {
                this.finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
