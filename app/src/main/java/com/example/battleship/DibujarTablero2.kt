package com.example.battleship

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import androidx.core.view.GestureDetectorCompat
import bds.posicion.PosModel

class DibujarTablero2: View, GestureDetector.OnGestureListener,
GestureDetector.OnDoubleTapListener {

    private lateinit var mDetector: GestureDetectorCompat

    var x = 0
    var y = 0
    var pincel1 = Paint()

    var objetosBX = mutableListOf<ObjectDrag2>()

    constructor(ctx: Context):super(ctx){
    }

    constructor(ctx: Context, attrs: AttributeSet):super(ctx,attrs){}

    constructor(ctx: Context, attrs: AttributeSet, defStyleAttr: Int): super(ctx,attrs,defStyleAttr){

    }

    init{
        mDetector = GestureDetectorCompat(this.context,this)
        mDetector.setOnDoubleTapListener(this)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        var ancho: Int = canvas.width //1080
        var alto: Int = canvas.height //2257

        pincel1.style = Paint.Style.STROKE
        pincel1.textSize = 25f

        //Cuadro de 97
        var tablero = BitmapFactory.decodeResource(resources,R.drawable.tablero_opcional) //1000
        canvas.drawBitmap(tablero,null, Rect(50,300,1050,1300),pincel1)

        for(i in objetosBX){
            i.draw(canvas)
            invalidate()
        }

        canvas.drawText("$x, $y",5f,alto -20f,pincel1)

        invalidate()

    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        x = event.x.toInt()
        y = event.y.toInt()

        var obj = ObjectDrag2(this.context,x.toFloat(),y.toFloat())

        objetosBX.add(obj)

        when(event.action){
            MotionEvent.ACTION_DOWN-> {
                if(objetosBX.last().getState() == true){
                    objetosBX.last().sele(false)
                    objetosBX.last().enviarToque(x,y)
                    objetosBX.last().setState(false)
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
        return true
    }

    override fun onDoubleTapEvent(p0: MotionEvent?): Boolean {
        return true
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val ancho = 1080
        val alto = 1400

        setMeasuredDimension(ancho,alto)
    }
}