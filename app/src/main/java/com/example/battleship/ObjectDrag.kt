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
    private var x: Float
    private var y: Float
    private var mult = 0

    private var origenX = 0
    private var origenY = 0

    private var rows = 11
    private var cols = 11
    private var campo = arrayOfNulls<Int>(11)

    private lateinit var usersDBHelper: PosDBHelper

    init {
        this.x = x.toFloat()
        this.y = y.toFloat()
        this.imagen = Imagen
        this.mult = mult
        this.origenX = x.toInt()
        this.origenY = y.toInt()

        usersDBHelper = PosDBHelper(context)

        var result = usersDBHelper.insertBarco(
            PosModel(
                this.x.toString(),
                this.y.toString(), "0", "0", "0", "0", mult
            )
        )
    }


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val paint = Paint()

        var ancho: Int = canvas.width //1080
        var alto: Int = canvas.height //1977

        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 8f;

        var objeto = BitmapFactory.decodeResource(resources, this.imagen) //Barco chico 104x104
        canvas.drawBitmap(
            objeto,
            null,
            Rect(
                this.x.toInt(),
                this.y.toInt(),
                (this.x + (96 * mult)).toInt(),
                (this.y + 96).toInt()
            ),
            paint
        )
    }

    fun setActionDown(actionDown: Boolean) {
        this.actionDown = actionDown
    }

    fun getActionDown(): Boolean {
        return actionDown
    }

    fun setPosition(x: Float, y: Float) {
        this.x = x
        this.y = y
    }

    fun isTouched(x1: Float, y1: Float): Boolean {
        var res = false
        if (x1 >= this.x && x1 <= (this.x + (96 * mult)) && y1 >= this.y && y1 <= (this.y + 96)) {
            res = true
        }
        return res
    }

    fun asignarPocicionFinal(x1: Float, y1: Float) {
        if (x1 >= 116 && (x1 + (96 * mult) <= 1060) && y1 >= 696 && (y1 + 96 <= 1660)) {

            var campox = 116
            var campoy = 696
            while (campox <= x1) {
                campox += 96
            }
            while (campoy <= y1) {
                campoy += 96
            }
            campox -= 96

            this.setPosition(campox.toFloat(), campoy.toFloat())

            var result = usersDBHelper.updateJug(
                campox.toString(),
                campoy.toString(), mult
            )

            //Nececito generar numeros random para la pocicion del barco
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

            var posiciones = usersDBHelper.obtenerInfoJugador(mult)

        } else {
            setPosition(this.origenX.toFloat(), this.origenY.toFloat())
        }
    }

    fun asignarCuadrados(x1: Float, y1: Float): Point {
        var ps = Point(0, 0)
        if (x1 >= 116 && (x1 + (96 * mult) <= 1070) && y1 >= 696 && (y1 + 96 <= 1660)) {

            var campox = 116
            var campoy = 696
            while (campox <= x1) {
                campox += 96
            }
            while (campoy <= y1) {
                campoy += 96
            }
            campox -= 96

            ps.x = campox
            ps.y = campoy
            return ps
        }
        return ps
    }

    fun asignarCuadrados2(x1: Float, y1: Float): Point {
        var ps = Point(0, 0)
        if (x1 >= 50 && (x1 + (100) <= 1050) && y1 >= 300 && (y1 + 100 <= 1300)) {
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