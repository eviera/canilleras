package net.eviera.canilleras

import android.graphics.drawable.Drawable
import android.graphics.drawable.LayerDrawable
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_cuatro_canilleras.*

class CuatroCanillerasActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cuatro_canilleras)

        val plantillaFondoBlancoConEdit = ContextCompat.getDrawable(this, R.drawable.prueba_fondo_blanco_con_borde_y_edit)
        val bgBordeImageview = ContextCompat.getDrawable(this, R.drawable.bg_borde_imageview)
        val pele = ContextCompat.getDrawable(this, R.drawable.pele)

        val layerDrawable = LayerDrawable(arrayOf<Drawable?>(bgBordeImageview, pele, plantillaFondoBlancoConEdit))
        plantilla_arr_izq.setImageDrawable(layerDrawable)
        //plantilla_arr_izq.setBackgroundResource(R.drawable.bg_borde_imageview)

        //frut
        val layerDrawableVacio = LayerDrawable(arrayOf<Drawable?>(bgBordeImageview, plantillaFondoBlancoConEdit))
        plantilla_arr_der.setImageDrawable(layerDrawableVacio)
        plantilla_abj_izq.setImageDrawable(layerDrawableVacio)
        plantilla_abj_der.setImageDrawable(layerDrawableVacio)


    }
}


