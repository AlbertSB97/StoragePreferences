package com.example.sharedpreferences

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.example.sharedpreferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var pref: Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        pref = Preferences(applicationContext)

        binding.btGuardar.setOnClickListener {
            guardarDatos()
        }

        binding.btMostrar.setOnClickListener {
            mostrarValor(pref.getNombre(), pref.getColor())
        }

        binding.btBorrar.setOnClickListener {
            pref.borrarDatos()
            mostrarValor(pref.getNombre(), pref.getColor())
        }
    }

    private fun guardarDatos(){
        if(binding.editTextNombre.text.toString().isNotEmpty() && binding.editTextColor.text.toString().isNotEmpty()){
            pref.guardarDatos(
                binding.editTextNombre.text.toString(),
                binding.editTextColor.text.toString()
            )
        }
    }

    private fun mostrarValor(title: String, message: String){
        val alert = AlertDialog.Builder(this)
        alert.setTitle(title)
        alert.setMessage(message)
        val dialog = alert.create()
        dialog.show()
    }

}