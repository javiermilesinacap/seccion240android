package com.example.appventas240

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.appventas240.models.Producto

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var elproducto = Producto("Cocacola",22)

    }
}