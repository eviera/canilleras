package net.eviera.canilleras

import android.content.Intent
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
import android.view.View


class CuatroCanillerasActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cuatro_canilleras)

        val plantillaFondoBlancoConEdit = ContextCompat.getDrawable(this, R.drawable.prueba_fondo_blanco_con_borde_y_edit)
        val plantillaFondoBlancoConEdit_CHICO = ContextCompat.getDrawable(this, R.drawable.prueba_fondo_blanco_con_borde_y_edit_chico)
        val plantillaFondoBlancoConEdit_SIN_BORDER = ContextCompat.getDrawable(this, R.drawable.prueba_fondo_blanco_y_edit)
        val bgBordeImageview = ContextCompat.getDrawable(this, R.drawable.bg_borde_imageview)
        val pele = ContextCompat.getDrawable(this, R.drawable.pele)

        //Con LayerDrawable
        /*
        val layerDrawable = LayerDrawable(arrayOf<Drawable?>(bgBordeImageview, pele, plantillaFondoBlancoConEdit))
        plantilla_arr_izq.setImageDrawable(layerDrawable)
        */

        //Con LayerDrawable Chico
        /*
        val layerDrawable = LayerDrawable(arrayOf<Drawable?>(pele, plantillaFondoBlancoConEdit_CHICO))
        plantilla_arr_izq.setImageDrawable(layerDrawable)
        */

        //Con LayerDrawable sin borde
        val layerDrawable = LayerDrawable(arrayOf<Drawable?>(bgBordeImageview, pele, plantillaFondoBlancoConEdit_SIN_BORDER))
        plantilla_arr_izq.setImageDrawable(layerDrawable)

        //Con Bitmap
        /*
        val layerDrawable = LayerDrawable(arrayOf<Drawable?>(pele, plantillaFondoBlancoConEdit))
        val b = Bitmap.createBitmap(108, 192, Bitmap.Config.ARGB_8888)
        layerDrawable.setBounds(0, 0, 108, 192)
        layerDrawable.draw(Canvas(b))
        plantilla_arr_izq.setImageBitmap(b)
        */


        /*
    Paint p = new Paint();
    p.setAntiAlias(true);
    p.setFilterBitmap(true);
    canvas.drawBitmap(someBitmap, new Matrix(), p);
 */


        //frut
        val layerDrawableVacio = LayerDrawable(arrayOf<Drawable?>(bgBordeImageview, plantillaFondoBlancoConEdit_SIN_BORDER))
        plantilla_arr_der.setImageDrawable(layerDrawableVacio)
        plantilla_abj_izq.setImageDrawable(layerDrawableVacio)
        plantilla_abj_der.setImageDrawable(layerDrawableVacio)


    }

    fun editCanillera(v: View) {
        val editCanilleraActivity = Intent(this, EditCanilleraActivity::class.java)
        startActivity(editCanilleraActivity)

        transitionZoomExit()
    }
}


