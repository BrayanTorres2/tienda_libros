package com.ean.tienda_libros

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import java.lang.Exception
import  Mundo.LaTienda.agregarlibro
import java.text.SimpleDateFormat
import  Mundo.LaTienda.mostrar_todos_los_nombres_libros
import androidx.appcompat.widget.AppCompatButton


class agregar_boton : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_boton)
        //botones
        val boton_volver=findViewById<ImageView>(R.id.view_backImage_agregar)
        val boton_agregar=findViewById<AppCompatButton>(R.id.bn_agregar_agregar)
        //Editext
        val txt_codigo=findViewById<EditText>(R.id.text_codigo_agregar)
        val txt_nombre=findViewById<EditText>(R.id.text_nombre_agregar)
        val txt_autor=findViewById<EditText>(R.id.text_autor_agregar)
        val txt_editoria=findViewById<EditText>(R.id.text_editorial_agregar)
        val txt_paginas=findViewById<EditText>(R.id.text_paginas_agregar)
        val text_fecha=findViewById<EditText>(R.id.text_fecha_publicacion_agregar)
        text_fecha.setOnClickListener { showDatePickerDialog() }
        //Funciones de botones
        boton_volver.setOnClickListener{
            val intent= Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
        boton_agregar.setOnClickListener {
            try{
                val codigo=txt_codigo.text.toString().toInt()
                val nombre=txt_nombre.text.toString()
                val autor=txt_autor.text.toString()
                val editorial=txt_editoria.text.toString()
                val paginas=txt_paginas.text.toString().toInt()
                val fecha_publicacion=text_fecha.text.toString()
                val formatter = SimpleDateFormat("yyyy-MM-dd")
                val date = formatter.parse(fecha_publicacion)

                if(codigo>999 && nombre.isNotEmpty() && autor.isNotEmpty() &&editorial.isNotEmpty() && paginas>3 &&fecha_publicacion.isNotEmpty() ){
                    agregarlibro(codigo,nombre,autor,editorial,paginas, date)
                    Toast.makeText(this,"Libro agregado",Toast.LENGTH_LONG).show()
                    println(mostrar_todos_los_nombres_libros())
                }
                else{
                    Toast.makeText(this,"Los campos no pueden estar vacios",Toast.LENGTH_LONG).show()
                }

            }
            catch (e:Exception){
                Toast.makeText(this,e.message,Toast.LENGTH_LONG).show()
            }
        }

    }

    private fun showDatePickerDialog() {
        //para que no tengamos error pasaremos como argumento a otra funcion
        val datepicker=DatePickerFragment({day,month,year ->OnDateSelected(day,month,year)})//objeto de la clase picker fragment
        //instancia
        datepicker.show(supportFragmentManager,"datepicker")
    }

    fun OnDateSelected(day:Int,month:Int,year:Int){
        val text_fecha=findViewById<EditText>(R.id.text_fecha_publicacion_agregar)
        text_fecha.setText("$year-$month-$day")
    }
}