package com.example.sharedpreferences

import android.content.Context

class Preferences(context: Context) {
    val PREF_NOMBRE = "MisDatos"
    val PREF_USUARIO = ""
    val PREF_COLOR = ""

    val pref = context.getSharedPreferences(PREF_NOMBRE, Context.MODE_PRIVATE)

    fun guardarDatos(nombre: String, color: String){
        pref.edit().putString(PREF_USUARIO, nombre).apply()
        pref.edit().putString(PREF_COLOR, color).apply()
    }

    fun getNombre(): String{
        return pref.getString(PREF_USUARIO, "No se ha rellenado")!!
    }

    fun getColor(): String{
        return pref.getString(PREF_COLOR, "No se ha rellenado")!!
    }

    fun borrarDatos(){
        pref.edit().remove(PREF_USUARIO).apply()
        pref.edit().remove(PREF_COLOR).apply()
    }
}