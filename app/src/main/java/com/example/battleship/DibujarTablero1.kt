package com.example.battleship

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import androidx.core.view.GestureDetectorCompat


class DibujarTablero1: View,GestureDetector.OnGestureListener,
GestureDetector.OnDoubleTapListener{

//    class DibujarTablero1(context: Context): View(context),GestureDetector.OnGestureListener,
//        GestureDetector.OnDoubleTapListener{
    constructor(ctx: Context):super(ctx){
    }

    constructor(ctx: Context,attrs:AttributeSet):super(ctx,attrs){}

    constructor(ctx: Context,attrs: AttributeSet,defStyleAttr: Int): super(ctx,attrs,defStyleAttr){

    }

    val paint = Paint ()
    val paintText = Paint()

    private lateinit var mDetector: GestureDetectorCompat

    var x = 0
    var y = 0

    //Pociciones pa los barcos
    var objbarcoArray = arrayOf<ObjectDrag>(
        ObjectDrag(this.context,40f,202f, R.drawable.barc1,1),
        ObjectDrag(this.context,200f,202f, R.drawable.barc2,2),
        ObjectDrag(this.context,500f,202f, R.drawable.barc3,3),
        ObjectDrag(this.context,40f,306f, R.drawable.barc4,4),
        ObjectDrag(this.context,500f,306f, R.drawable.barc5,5))

    init{
        mDetector = GestureDetectorCompat(this.context,this)
        mDetector.setOnDoubleTapListener(this)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        var ancho: Int = canvas.width //1080
        var alto: Int = canvas.height //2257

        //println("Alto: $alto, Ancho: $ancho")

//        Todas las imagenes deben de tener menos de 1000px
//                caso contrario se deben redimencionar

        //Dibujando Diseño de Campo
        val ddc = BitmapFactory.decodeResource(resources, R.drawable.tit_disenio)
        canvas.drawBitmap(ddc, null, Rect(0, 0, ancho, 170), paint)

        //Dibujando Rectangulo
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 8f;
        canvas.drawRect(Rect(20, 200, ancho - 20, 500), paint)

        //Dibujando barcos
        paintText.style = Paint.Style.FILL
        paintText.strokeWidth = 2f
        paintText.textSize = 25f

        for (i in objbarcoArray.indices){
            objbarcoArray.get(i).draw(canvas)
        }

        canvas.drawText("$x, $y",5f,alto -20f,paintText)

        //Dibujar tablero
        var tablero = BitmapFactory.decodeResource(resources,R.drawable.tablero) //1060*1060
        canvas.drawBitmap(tablero,null,Rect(20,600,ancho-20,1660),paint)

        invalidate()
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
            x = event.x.toInt()
            y = event.y.toInt()

        when(event.action){
            MotionEvent.ACTION_DOWN->{
                for(i in objbarcoArray.indices) {
                    if (objbarcoArray.get(i).isTouched(event.x, event.y) && !objbarcoArray.get(i).getActionDown())
                        objbarcoArray.get(i).setActionDown(true)
                }
            }
            MotionEvent.ACTION_MOVE ->{
                for(i in objbarcoArray.indices) {
                    if (objbarcoArray.get(i).getActionDown()) {
                        objbarcoArray.get(i).setPosition(event.x, event.y)
                    }
                }
            }
            MotionEvent.ACTION_UP -> {
                for(i in objbarcoArray.indices) {
                    if (objbarcoArray.get(i).getActionDown()) {
                        objbarcoArray.get(i).asignarPocicionFinal(event.x,event.y)
                        objbarcoArray.get(i).setActionDown(false)
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
        val alto = 1700

        setMeasuredDimension(ancho,alto)
    }
}