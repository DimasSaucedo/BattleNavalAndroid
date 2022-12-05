package com.example.battleship

import android.content.Context
import android.graphics.*
import android.view.View
import bds.posicion.PosDBHelper
import bds.posicion.PosModel
import kotlin.random.Random

class ObjectDrag(context: Context, x:Float, y:Float, Imagen: Int,mult: Int): View(context) {

    private var imagen: Int
    private var actionDown = false
    private var xod: Float = 0.0f
    private var yod: Float = 0.0f
    private var mult = 0

    private var origenX = 0
    private var origenY = 0

    private var rows = 11
    private var cols = 11
    private var campo = arrayOfNulls<Int>(11)

    val paint = Paint()

    private lateinit var usersDBHelper: PosDBHelper

    init {
        this.xod = x.toFloat()
        this.yod = y.toFloat()
        this.imagen = Imagen
        this.mult = mult
        this.origenX = x.toInt()
        this.origenY = y.toInt()

        usersDBHelper = PosDBHelper(context)

        var result = usersDBHelper.insertBarco(
            PosModel(
                this.xod.toString(),
                this.yod.toString(), "0", "0", "0", "0", mult
            )
        )

        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 8f;
    }


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        var objeto = BitmapFactory.decodeResource(resources, this.imagen) //Barco chico 104x104
        canvas.drawBitmap(
            objeto,
            null,
            Rect(
                this.xod.toInt(),
                this.yod.toInt(),
                (this.xod + (96 * mult)).toInt(),
                (this.yod + 96).toInt()
            ),
            paint
        )
        invalidate()
    }

    fun setActionDown(actionDown: Boolean) {
        this.actionDown = actionDown
    }

    fun getActionDown(): Boolean {
        return actionDown
    }

    fun setPosition(x: Float, y: Float) {
        this.xod = x
        this.yod = y
        invalidate()
    }

    fun isTouched(x1: Float, y1: Float): Boolean {
        var res = false
        if (x1 >= this.xod && x1 <= (this.xod + (100 * mult)) && y1 >= this.yod && y1 <= (this.yod + 100)) {
            res = true
        }
        return res
    }

    fun asignarPocicionFinal(x1: Float, y1: Float) {
        if (x1 >= 50 && (x1 + (100 * mult) <= 1100) && y1 >= 700 && (y1 + 96 <= 1800)) {

            var campox = 50
            var campoy = 700
            while (campox <= x1) {
                campox += 100
            }
            while (campoy <= y1) {
                campoy += 100
            }
            campox -= 100
            campoy -= 100

            this.setPosition(campox.toFloat(), campoy.toFloat())

            println("Guardando barco: ${mult}")
            var result = usersDBHelper.updateJug(
                campox.toString(),
                campoy.toString(), mult
            )

            //Nececito generar numeros random para la pocicion del barco
            crearBarcoEnemigo(mult)
        } else {
            setPosition(this.origenX.toFloat(), this.origenY.toFloat())
        }
    }

    fun crearBarcoEnemigo(mult: Int) {
        when (mult) {
            1 -> {
                var x1E = Random.nextInt(50, 1050)
                var y1E = Random.nextInt(300, 1300)
                var pse = Point()
                pse = asignarCuadrados2(x1E.toFloat(), y1E.toFloat())


                var result1 = usersDBHelper.updateCon(
                    pse.x.toString(),
                    pse.y.toString(),
                    mult
                )
            }
            2 -> {
                var x1E = Random.nextInt(50, 950)
                var y1E = Random.nextInt(300, 1300)
                var pse = Point()
                pse = asignarCuadrados2(x1E.toFloat(), y1E.toFloat())

                var result1 = usersDBHelper.updateCon(
                    pse.x.toString(),
                    pse.y.toString(),
                    mult
                )
            }
            3 -> {
                var x1E = Random.nextInt(50, 850)
                var y1E = Random.nextInt(300, 1300)
                var pse = Point()
                pse = asignarCuadrados2(x1E.toFloat(), y1E.toFloat())

                var result1 = usersDBHelper.updateCon(
                    pse.x.toString(),
                    pse.y.toString(),
                    mult
                )
            }
            4 -> {
                var x1E = Random.nextInt(50, 750)
                var y1E = Random.nextInt(300, 1300)
                var pse = Point()

                pse = asignarCuadrados2(x1E.toFloat(), y1E.toFloat())

                var result1 = usersDBHelper.updateCon(
                    pse.x.toString(),
                    pse.y.toString(),
                    mult
                )

                //println("${pse.x} + ${pse.y},")
            }
            5 -> {
                var x1E = Random.nextInt(50, 650)
                var y1E = Random.nextInt(300, 1300)
                var pse = Point()
                pse = asignarCuadrados2(x1E.toFloat(), y1E.toFloat())

                var result1 = usersDBHelper.updateCon(
                    pse.x.toString(),
                    pse.y.toString(),
                    mult
                )
            }
        }
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
            //campoy -= 100

            ps.x = campox.toInt()
            ps.y = campoy.toInt()
            return ps
        }
        return ps
    }

}