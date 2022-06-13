package com.ean.tienda_libros

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val boton_agregar=findViewById<AppCompatButton>(R.id.bn_agregar_main)
        boton_agregar.setOnClickListener {
            val intent= Intent(this,agregar_boton::class.java)
            startActivity(intent)
        }
        val boton_mostrar_libro=findViewById<AppCompatButton>(R.id.bn_mostrar_main)
        boton_mostrar_libro.setOnClickListener {
            val intent= Intent(this,mostrar_libros::class.java)
            startActivity(intent)
        }
    }
}