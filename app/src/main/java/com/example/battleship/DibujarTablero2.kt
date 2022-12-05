package com.example.battleship

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import androidx.core.view.GestureDetectorCompat
import bds.posicion.*
import kotlin.random.Random

class DibujarTablero2: View, GestureDetector.OnGestureListener,
GestureDetector.OnDoubleTapListener {

    private lateinit var mDetector: GestureDetectorCompat

    var x = 0
    var y = 0
    var x1 = 0
    var y1 = 0
    var pincel1 = Paint()
    var puntos:Int = 0
    var puntosCon:Int = 0

    //Si esta falso es el turno del jugador
    var tableroDisponible = false
    var toqueuno = true

    lateinit var puntosConsola: String
    lateinit var puntosJugador: String

    var objetosBX = mutableListOf<ObjectDrag2>()
    var objectoEX = mutableListOf<ObjectDrag2>()
    var listaPos = mutableListOf<PosModel>()
    var listaPos2 = mutableListOf<PosModel>()

    var repetido = true
    var checado = true

    private lateinit var posDBHelper: PosDBHelper

    constructor(ctx: Context) : super(ctx) {
    }

    constructor(ctx: Context, attrs: AttributeSet) : super(ctx, attrs) {}

    constructor(ctx: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        ctx,
        attrs,
        defStyleAttr
    ) {

    }

    init {
        mDetector = GestureDetectorCompat(this.context, this)
        mDetector.setOnDoubleTapListener(this)
        posDBHelper = PosDBHelper(context)
        posDBHelper.insertPuntoConsola("0")
        posDBHelper.insertPuntoJugador("0")
        //puntosConsola = posDBHelper.obtenerPuntosConsola()
        posDBHelper.borrarToques()
        listaPos = posDBHelper.obtenerListaPos()
        listaPos2 = posDBHelper.obtenerListaPos()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        var ancho: Int = canvas.width //1080
        var alto: Int = canvas.height //2257

        var fondo = BitmapFactory.decodeResource(resources,R.drawable.fondo)
        canvas.drawBitmap(fondo,null,Rect(0,0,ancho,alto),pincel1)

        //pincel1.style = Paint.Style.STROKE
        //pincel1.strokeWidth = 8f;
        //canvas.drawRect(Rect(49,299,1051,1301),pincel1)

        if(!tableroDisponible) {
            pincel1.style = Paint.Style.STROKE
            pincel1.textSize = 25f

            var turnoJug = BitmapFactory.decodeResource(resources,R.drawable.turno_jugador)
            canvas.drawBitmap(turnoJug,null, Rect(30,50,1010,150),pincel1)

            //Cuadro de 100
            var tablero = BitmapFactory.decodeResource(resources, R.drawable.tablero_ene_rem) //1000
            canvas.drawBitmap(tablero, null, Rect(9, 200, 1050, 1300), pincel1)
            //canvas.drawBitmap(tablero, null, Rect(50, 300, 1050, 1300), pincel1)

            for (i in objetosBX) {
                i.draw(canvas)
                invalidate()
            }

            pincel1.style = Paint.Style.FILL
            pincel1.textSize = 70f
            //Extraemos Puntos de los enemigos y mostramos

            canvas.drawText("Puntos: ${this.puntos}", 30f, alto - 30f, pincel1)

            //canvas.drawText("$x, $y", 5f, alto - 20f, pincel1)

            if (this.puntos >= 15) {
                pincel1.style = Paint.Style.FILL_AND_STROKE
                pincel1.textSize = 70f
                //Extraemos Puntos de los enemigos y mostramos

                canvas.drawText("Jugador 1 Gano", 30f, alto - 50f, pincel1)
            }
        }else{
            var turnoCon = BitmapFactory.decodeResource(resources,R.drawable.turno_consola)
            canvas.drawBitmap(turnoCon,null,Rect(30,50,1010,150),pincel1)
            var tablero = BitmapFactory.decodeResource(resources,R.drawable.tablero_jug_rem) //1060*1060
            canvas.drawBitmap(tablero,null,Rect(9,200,1050,1300),pincel1)

            for (i in objectoEX) {
                i.draw(canvas)
                invalidate()
            }

            pincel1.style = Paint.Style.FILL
            pincel1.textSize = 70f
            //Extraemos Puntos de los enemigos y mostramos

            canvas.drawText("Puntos: ${this.puntosCon}", 30f, alto - 30f, pincel1)

            //canvas.drawText("$x, $y", 5f, alto - 20f, pincel1)

            if (this.puntos >= 15) {
                pincel1.style = Paint.Style.FILL_AND_STROKE
                pincel1.textSize = 70f
                //Extraemos Puntos de los enemigos y mostramos

                canvas.drawText("Consola Gano", 30f, alto - 50f, pincel1)
            }


        }
        invalidate()
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        x = event.x.toInt()
        y = event.y.toInt()

        x = asignarCuadrados2(x.toFloat(), y.toFloat()).x
        y = asignarCuadrados2(x.toFloat(), y.toFloat()).y

        if (x >= 50 && (x + (100) <= 1050) && y >= 300 && (y + 100 <= 1300)) {

            //Aqui estamos asignando el toque en la base de datos

            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    if(toqueuno) {
                        if (!tableroDisponible) {
                            if (verificarDisponible(x, y,1) == true) {
//                            println("Ya existe esta pocicion")
                            } else {
                                var obj = ObjectDrag2(this.context, x.toFloat(), y.toFloat())
                                objetosBX.add(obj)
                                if (objetosBX.last().getState() == true) {
                                    if (checarPunto(x, y,1)) {
                                        objetosBX.last().asignarPos(this.x1, this.y1)
                                        objetosBX.last().sele(1)
                                    } else {
                                        //objetosBX.last().asignarPos(this.x1, this.y1)
                                        objetosBX.last().sele(1)
                                    }
                                    objetosBX.last().setState(false)
                                }

                            }

                        } else {

                        }
                        Toast.makeText(context,"Doble toque para continuar",Toast.LENGTH_SHORT).show()
                        toqueuno = false
                    }
                }
            }
        }
        invalidate()
        return if (mDetector.onTouchEvent(event)) {
            true
        } else {
            super.onTouchEvent(event)
        }
    }

    fun generarPuntoConsola() {

        while (repetido == true || checado == true) {
//            x1 >= 50 && (x1 + (100) <= 1100) && y1 >= 300 && (y1 + 100 <= 1400
            var xr = Random.nextInt(50, 1000)
            var xy = Random.nextInt(300, 1300)
            println("$xr + $xy")
            var posx = asignarCuadrados2(xr.toFloat(), xy.toFloat()).x
            var posy = asignarCuadrados2(xr.toFloat(), xy.toFloat()).y
            println("["+posx +","+posy+"]")
            //var posToques = PosToques(posx.toString(),posy.toString())
            //posDBHelper.insertToqueConsola(posToques)
            if (verificarDisponible(posx, posy, 2) && posx != 0 && posy!=0) {
                //Existe esta pocicion
            } else {
                var obj1 = ObjectDrag2(this.context, posx.toFloat(), posy.toFloat())
                objectoEX.add(obj1)
                if (objectoEX.last().getState() == true) {
                    if (checarPunto(posx, posy, 2)) {
                        objectoEX.last().asignarPos(posx, posy)
                        objectoEX.last().sele(1)

                    } else {
                        //objetosBX.last().asignarPos(this.x1, this.y1)
                        objectoEX.last().sele(1)
                    }
                    objectoEX.last().setState(false)
                }
            }
            repetido = false
            checado = false
        }
        println("Generado")
    }

    override fun onDown(p0: MotionEvent?): Boolean {
        return true
    }

    override fun onShowPress(p0: MotionEvent?) {

    }

    override fun onSingleTapUp(p0: MotionEvent?): Boolean {
        return true
    }

    override fun onScroll(p0: MotionEvent?, p1: MotionEvent?, p2: Float, p3: Float): Boolean {

        return true
    }

    override fun onLongPress(p0: MotionEvent?) {

    }

    override fun onFling(p0: MotionEvent?, p1: MotionEvent?, p2: Float, p3: Float): Boolean {

        return true
    }

    override fun onSingleTapConfirmed(p0: MotionEvent?): Boolean {
        return true
    }

    override fun onDoubleTap(p0: MotionEvent?): Boolean {
        if(!tableroDisponible){
            generarPuntoConsola()
            tableroDisponible = true

        }else {
            tableroDisponible = false
            repetido = true
            checado = true
        }
        toqueuno = true
        invalidate()
        return true
    }

    override fun onDoubleTapEvent(p0: MotionEvent?): Boolean {

        return true
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val ancho = 1080
        val alto = 1400

        setMeasuredDimension(ancho, alto)
    }

    fun checarPunto(x: Int, y: Int,turno: Int):Boolean {
        var puntosCuadro = asignarCuadrados2(x.toFloat(), y.toFloat())
        //println("Toque: [x:${puntosCuadro.x},y:${puntosCuadro.y}]")

        if(turno==1){

            for (lista in listaPos) {
            //println("Enemigo ${lista.noBarco}: [x:${lista.conX1},y:${lista.conY1}]")
                if (puntosCuadro.x >= lista.conX1.toInt() && puntosCuadro.x < (lista.conX1.toInt()+(100*lista.noBarco)) &&
                            puntosCuadro.y == lista.conY1.toInt()) {
                    //println("Acertaste")
                    objetosBX.last().asignarImagen(R.drawable.estallido)
                    this.x1 = puntosCuadro.x
                    this.y1 = puntosCuadro.y

//                    println("-----")
                    //Aqui estamos asignando puntos en la base
                    this.puntosConsola = posDBHelper.obtenerPuntosConsola()
                    this.puntos = puntosConsola.toInt()
                    this.puntos++
                    posDBHelper.updatePuntosConsola(this.puntos.toString())

                    return true
                    } else {
                    //println("Fallaste")
                    objetosBX.last().asignarImagen(R.drawable.cuadro_rojo)
                    this.x1 = puntosCuadro.x
                    this.y1 = puntosCuadro.y
                }
            }
        }else{

            println(listaPos2.size)

            for (lista in listaPos2) {
                println("Enemigo ${lista.noBarco}: [x:${lista.jugX},y:${lista.jugY}]")
                if (puntosCuadro.x >= lista.jugX.toInt() && puntosCuadro.x < (lista.jugX.toInt()+(100*lista.noBarco)) &&
                    puntosCuadro.y == lista.jugY.toInt()) {
                    //println("Acertaste")
                    objectoEX.last().asignarImagen(R.drawable.estallido)
                    this.x1 = puntosCuadro.x
                    this.y1 = puntosCuadro.y

                    //Aqui estamos asignando puntos en la base
                    this.puntosJugador = posDBHelper.obtenerPuntosJugador()
                    this.puntosCon = puntosJugador.toInt()
                    this.puntosCon++
                    posDBHelper.updatePuntosJugador(this.puntosCon.toString())

                    return true
                } else {
                    //println("Fallaste")
                    objectoEX.last().asignarImagen(R.drawable.cuadro_azul)
                }
        }

//        println("----")
    }
        return false
    }


    fun verificarDisponible(x:Int,y:Int,jc:Int):Boolean {
        if (jc == 1) {
            //Obtenemos la lista de toques
            var listaToques = posDBHelper.obtenerToquesJugador()

            for (lista in listaToques) {

                if (lista.toqX == x.toString() && lista.toqY == y.toString()) {
//                println("Si existe la pocicion")
                    return true
                }
            }
            var toque = PosToques(x.toString(), y.toString())
            posDBHelper.insertToqueJugador(toque)
        } else {
            var listaToques = posDBHelper.obtenerToquesConsola()

            for (lista in listaToques) {

                if (lista.toqX == x.toString() && lista.toqY == y.toString()) {
//                println("Si existe la pocicion")
                    return true
                }else{
                    println("No existe esta pocicion")
                }
            }
            var toque = PosToques(x.toString(), y.toString())
            posDBHelper.insertToqueConsola(toque)
        }
        return false
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

    fun reasignarToques(){

    }
}