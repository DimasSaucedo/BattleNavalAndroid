package com.example.battleship

import android.content.Context
import android.graphics.*
import android.view.View

class ObjectDrag(context: Context, x:Float, y:Float, Imagen: Int,mult: Int): View(context) {

    private var imagen:Int
    private var actionDown = false
    private var x:Float
    private var y: Float
    private var mult = 0

    private var origenX = 0
    private var origenY = 0

    private var rows = 11
    private var cols = 11
    private var campo = arrayOfNulls<Int>(11)

    init{
        this.x = x.toFloat()
        this.y = y.toFloat()
        this.imagen = Imagen
        this.mult = mult
        this.origenX = x.toInt()
        this.origenY = y.toInt()

        llenarCampo()
    }

    fun llenarCampo(){


//        for(row in campo){
//            println(row.contentToString())
//        }
    }

    override fun onDraw(canvas: Canvas){
        super.onDraw(canvas)

        val paint = Paint ()

        var ancho: Int = canvas.width //1080
        var alto: Int = canvas.height //1977

        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 8f;

        var objeto = BitmapFactory.decodeResource(resources,this.imagen) //Barco chico 104x104
        canvas.drawBitmap(objeto,null, Rect(this.x.toInt(), this.y.toInt(), (this.x+(96*mult)).toInt(), (this.y+96).toInt()),paint)
    }

    fun setActionDown (actionDown: Boolean){
        this.actionDown = actionDown
    }

    fun getActionDown(): Boolean {
        return actionDown
    }

    fun setPosition(x: Float, y: Float){
        this.x = x
        this.y = y
    }

    fun isTouched(x1:Float,y1:Float):Boolean{
        var res = false
        if(x1 >= this.x && x1<= (this.x+(96*mult)) && y1 >= this.y && y1 <= (this.y+96)){
            res = true
        }
        return res
    }

    fun asignarPocicionFinal(x1:Float, y1: Float){
        if(x1>=116 && (x1+(96*mult) <= 1060) && y1 >= 696 && (y1+96<= 1660)){
            println("Pocion barco x: ${this.x}, y: ${this.y}")
            var campox = 116
            var campoy = 696
            while (campox <= x1){
                campox+=96
            }
            while (campoy <= y1){
                campoy+=96
            }
            campox -=96

            this.setPosition(campox.toFloat(), campoy.toFloat())
        }else{
            setPosition(this.origenX.toFloat(), this.origenY.toFloat())
        }
    }
}
