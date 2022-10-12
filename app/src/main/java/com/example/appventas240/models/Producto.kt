package com.example.appventas240.models

class Producto {
    var _id : Int = 0
    var nombreProducto: String = ""
    var cantidad : Int=0
    constructor(nombreProducto: String, cantidad: Int){
        this.nombreProducto = nombreProducto
        this.cantidad = cantidad
    }
    constructor(_id: Int, nombreProducto: String, cantidad: Int){
        this._id = _id
        this.nombreProducto = nombreProducto
        this.cantidad = cantidad
    }
}