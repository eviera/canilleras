package net.eviera.canilleras

import android.graphics.drawable.Drawable
import android.graphics.drawable.LayerDrawable
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_cuatro_canilleras.*
import android.opengl.ETC1.getHeight
import android.opengl.ETC1.getWidth
import android.graphics.Bitmap
import android.graphics.Canvas


class CuatroCanillerasActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cuatro_canilleras)

        val plantillaFondoBlancoConEdit = ContextCompat.getDrawable(this, R.drawable.prueba_fondo_blanco_con_borde_y_edit)
        val bgBordeImageview = ContextCompat.getDrawable(this, R.drawable.bg_borde_imageview)
        val pele = ContextCompat.getDrawable(this, R.drawable.pele)

        //Con LayerDrawable
        //val layerDrawable = LayerDrawable(arrayOf<Drawable?>(bgBordeImageview, pele, plantillaFondoBlancoConEdit))
        //plantilla_arr_izq.setImageDrawable(layerDrawable)

        //Con Bitmap
        val layerDrawable = LayerDrawable(arrayOf<Drawable?>(pele, plantillaFondoBlancoConEdit))
        val b = Bitmap.createBitmap(108, 192, Bitmap.Config.ARGB_8888)
        layerDrawable.setBounds(0, 0, 108, 192)
        layerDrawable.draw(Canvas(b))
        /*
            Paint p = new Paint();
            p.setAntiAlias(true);
            p.setFilterBitmap(true);
            canvas.drawBitmap(someBitmap, new Matrix(), p);
         */

        plantilla_arr_izq.setImageBitmap(b)

        //frut
        val layerDrawableVacio = LayerDrawable(arrayOf<Drawable?>(bgBordeImageview, plantillaFondoBlancoConEdit))
        plantilla_arr_der.setImageDrawable(layerDrawableVacio)
        plantilla_abj_izq.setImageDrawable(layerDrawableVacio)
        plantilla_abj_der.setImageDrawable(layerDrawableVacio)


    }
}


