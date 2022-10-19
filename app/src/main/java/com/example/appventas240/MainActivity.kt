package com.example.appventas240

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.appventas240.datos.Base
import com.example.appventas240.models.Producto
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var elproducto = Producto("Cocacola",22)
        //SQLITE
        var mibase = Base(this,null,null,null)
        mibase.adProducto(elproducto)
        //Objeto de la Base de Datos
        val database = Firebase.database
        val myRef = database.getReference("message")
        //FIN SQLITE

        //LEER DESDE FIREBASE
        // Read from the database
        val elTitulo : TextView = findViewById(R.id.main_txtTitulo)
        myRef.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                val value = snapshot.getValue<String>()
                elTitulo.text = value.toString()
                Log.d("DESDE FIREBASE", "Value is: " + value)
            }
            override fun onCancelled(error: DatabaseError) {
                Log.w("Desde Firebase", "Failed to read value.", error.toException())
            }
        })
        //FIN LEER FIREBASE

        val elBoton : Button
        elBoton = findViewById(R.id.main_btnAcceder)
        elBoton.setOnClickListener(View.OnClickListener {
            // Write a message to the database
            myRef.setValue("Hello, World!")
        })
    }
}