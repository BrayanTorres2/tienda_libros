package com.ean.tienda_libros

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView
import Mundo.LaTienda.mostrar_todos_los_nombres_libros
import android.widget.Toast

class mostrar_libros : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mostrar_libros)
        //botones
        val boton_volver=findViewById<ImageView>(R.id.view_volver_mostrar)
        boton_volver.setOnClickListener{
            val intent= Intent(this,boton_volver::class.java)
            startActivity(intent)
        }
        //lista
        val lista_de_libros=findViewById<ListView>(R.id.list_libros_mostrar)
        val libros= mostrar_todos_los_nombres_libros()
        val adaptlibros= ArrayAdapter(this,android.R.layout.simple_list_item_1,libros)
        lista_de_libros.adapter=adaptlibros

        lista_de_libros.setOnItemClickListener(){parent,view,position,id->
            Toast.makeText(this,parent.getItemAtPosition(position).toString(),Toast.LENGTH_LONG).show()
        }
    }
}