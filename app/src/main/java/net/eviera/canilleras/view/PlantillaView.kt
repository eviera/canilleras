package net.eviera.canilleras.view

import android.content.Context
import android.graphics.Canvas
import android.support.v7.widget.AppCompatImageView
import android.util.AttributeSet


class PlantillaView(context: Context, attributeSet: AttributeSet) : AppCompatImageView(context, attributeSet) {


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        /*
        if (canvas != null) {
            val paint = Paint()
            paint.style = Paint.Style.FILL
            paint.color = Color.BLUE
            canvas.drawCircle(100f,100f, 10f, paint)
        }
        */
    }
}