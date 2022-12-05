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
    private lateinit var posDBHelper: PosDBHelper
    var listaPos = mutableListOf<PosModel>()
    var sele: Boolean? = null
    var state: Boolean? = true

    var paint = Paint()

    init {
        this.x1 = x.toInt()
        this.y1 = y.toInt()
        posDBHelper = PosDBHelper(context)
    }

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        paint.style = Paint.Style.STROKE

        when (this.sele) {
            true -> {
                var objeto =
                    BitmapFactory.decodeResource(
                        resources,
                        R.drawable.estallido
                    ) //Barco chico 104x104
                canvas.drawBitmap(
                    objeto,
                    null,
                    Rect(
                        this.x1.toInt(),
                        this.y1.toInt(),
                        (this.x1 + (100)).toInt(),
                        (this.y1 + 100).toInt()
                    ),
                    paint
                )
                invalidate()
            }
            false -> {
                var objeto =
                    BitmapFactory.decodeResource(
                        resources,
                        R.drawable.cuadro_azul
                    ) //Barco chico 104x104
                canvas.drawBitmap(
                    objeto,
                    null,
                    Rect(
                        this.x1.toInt(),
                        this.y1.toInt(),
                        (this.x1 + (100)).toInt(),
                        (this.y1 + 100).toInt()
                    ),
                    paint
                )
                invalidate()
            }
        }
        invalidate()
    }

    fun enviarToque(x: Int, y: Int) {
        var puntosCuadro = asignarCuadrados2(x.toFloat(), y.toFloat())
        println("Toque: [x:${puntosCuadro.x},y:${puntosCuadro.y}]")

        listaPos = posDBHelper.obtenerListaPos()

        for (lista in listaPos) {

            println("Enemigo: [x:${lista.conX1},y:${lista.conY1}]")
            if ((puntosCuadro.x == lista.conX1.toInt() && puntosCuadro.y == lista.conY1.toInt()) ||
                (puntosCuadro.x == ((lista.conX1.toInt() * lista.noBarco) + 100) && puntosCuadro.y == lista.conY1.toInt())
            ) {
                println("Acertaste")
                sele(true)
                this.x1 = puntosCuadro.x
                this.y1 = puntosCuadro.y
                invalidate()
            } else {
                println("Fallaste")
                sele(false)
                this.x1 = puntosCuadro.x
                this.y1 = puntosCuadro.y
                invalidate()
            }
        }
    }

    fun sele(selec: Boolean){
        this.sele = selec
    }

    fun setState(estado: Boolean) {
        this.state = estado
    }

    @JvmName("getState1")
    fun getState(): Boolean? {
        return this.state
    }

    fun asignarCuadrados2(x1: Float, y1: Float): Point {
        var ps = Point(0, 0)
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

            ps.x = campox.toInt()
            ps.y = campoy.toInt()
            return ps
        }
        return ps
    }
}