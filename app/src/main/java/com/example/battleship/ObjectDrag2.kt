package com.example.battleship

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.text.BoringLayout
import android.view.View
import bds.posicion.PosDBHelper
import bds.posicion.PosModel

class ObjectDrag2(context: Context, x: Float, y:Float): View(context) {

    private var x1: Int
    private var y1: Int

    var imagen: Int = 0

    var sele = 0
    var state: Boolean? = true


    var paint = Paint()

    init {
        this.x1 = x.toInt()
        this.y1 = y.toInt()
    }

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        paint.style = Paint.Style.STROKE

        if(sele==1) {
            var objeto = BitmapFactory.decodeResource(resources, this.imagen) //Barco chico 104x104
            canvas.drawBitmap(objeto, null, Rect(this.x1, this.y1, (this.x1 + (100)), (this.y1 + 100)), paint)
            invalidate()
        }

    }

    fun asignarImagen(imagen:Int){
        this.imagen = imagen
    }

    fun asignarPos(x:Int, y:Int){
        asignarCuadrados2(x.toFloat(),y.toFloat())
    }

    fun sele(selec: Int){
        this.sele = selec
    }

    fun setState(estado: Boolean) {
        this.state = estado
    }

    @JvmName("getState1")
    fun getState(): Boolean? {
        return this.state
    }

    fun asignarCuadrados2(x1: Float, y1: Float){
        if (x1 >= 50 && (x1 + (100) <= 1100) && y1 >= 300 && (y1 + 100 <= 1400)) {
            var campox = 50.0
            var campoy = 300.0
            while (campox <= x1) {
                campox += 100
            }
            while (campoy <= y1) {
                campoy += 100
            }
            campox -= 100
            campoy -= 100

            this.x1= campox.toInt()
            this.y1  = campoy.toInt()
        }
    }
}