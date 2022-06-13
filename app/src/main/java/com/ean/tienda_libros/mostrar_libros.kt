package com.ean.tienda_libros

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import Mundo.LaTienda.mostrar_todos_los_nombres_libros
import android.widget.*
import androidx.core.view.contains
import java.util.*

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
        val buscar=findViewById<SearchView>(R.id.SeatchView)
        val libros= mostrar_todos_los_nombres_libros()
        val adaptlibros= ArrayAdapter(this,android.R.layout.simple_list_item_1,libros)
        lista_de_libros.adapter=adaptlibros
        buscar.setOnQueryTextListener(object :SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(p0: String?): Boolean {
                buscar.clearFocus()
                if(lista_de_libros.contains()){

                }
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                TODO("Not yet implemented")
            }

        })
        lista_de_libros.setOnItemClickListener(){parent,view,position,id->
            Toast.makeText(this,parent.getItemAtPosition(position).toString(),Toast.LENGTH_LONG).show()
        }
    }
}


