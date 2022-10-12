package com.example.appventas240.datos

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteDatabase.CursorFactory
import android.database.sqlite.SQLiteOpenHelper
import com.example.appventas240.models.Producto

class Base(context: Context, nombre: String?, factory: CursorFactory, version: Int) :
    SQLiteOpenHelper(context, NOMBREBASE, factory, VERSION) {
      companion object{
          private val NOMBREBASE="productos.db"
          private val VERSION = 1
          val TABLA_PRODUCTO = "productos"

          val COLUMN_ID = "_id"
          val COLUMN_NOMBREPRODUCTIO = "nombreproducto"
          val COLUMN_CANTIDAD = "cantidad"
      }

    override fun onCreate(p0: SQLiteDatabase?) {
        val sql = "CREATE TABLE $TABLA_PRODUCTO($COLUMN_ID PRIMARY KEY, $COLUMN_NOMBREPRODUCTIO TEXT, $COLUMN_CANTIDAD INTEGER)"
        if (p0 != null) {
            p0.execSQL(sql)
        }
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }
    fun adProducto(producto : Producto){
        val valores = ContentValues()
        valores.put(COLUMN_NOMBREPRODUCTIO, producto.nombreProducto)
        valores.put(COLUMN_CANTIDAD, producto.cantidad)
        val db = this.writableDatabase
        db.insert(TABLA_PRODUCTO,null, valores)
    }
}
