package Mundo
import ean.collections.TArrayList
import java.util.*
import kotlin.collections.ArrayList

data class Libro(var codigo:Int,var nombre:String,var autor:String,var editorial:String, var numero_paginas:Int,var fecha_publicacion:Date){

}
data class Empleado(var cc:Int,var nombre: String)

//patron si patron singleton
/*
El patrón Singleton está diseñado para restringir la creación de una clase a una sola instancia.
Este patrón se usa en un escenario donde tiene sentido tener solo uno de algo, como por ejemplo:
 una sola clase que organiza las interacciones de otros objetos, ej. Clase de gerente ; o una clase
  que representa un recurso único y único
 */

object LaTienda{
    var listadeLibros=TArrayList<Libro>()
    var listadeEmpleados=TArrayList<Libro>()
    //metodos

    //verifica si un libro esta en la lista
    fun verificarlibro(codigo: Int):Boolean{
        for ( i in listadeLibros){
            if(i.codigo==codigo){
                return true
            }
        }
        //listadeLibros.find { it.codigo==codigo } //otra manera de hacerlo
        return false
    }

    fun agregarlibro(codigo: Int,nombre: String,autor: String,editorial: String,numero_paginas: Int,fecha_publicacion: Date){
        var a=verificarlibro(codigo)
        if(a==false){
            listadeLibros.add(Libro(codigo,nombre,autor,editorial,numero_paginas,fecha_publicacion))
        }
    }
    fun elimina_un_libro(codigo: Int){
        var a= verificarlibro(codigo)
        if(a==true){
            for (i in listadeLibros){
                if(i.codigo==codigo){
                    listadeLibros.removeElement(i)
                }
            }
        }
    }
    fun mostrar_todos_los_nombres_libros():ArrayList<String>{
        require(!listadeLibros.isEmpty)
        var nombres=ArrayList<String>()
        for (i in listadeLibros){
            nombres.add(i.nombre)
        }
        return nombres
    }




}