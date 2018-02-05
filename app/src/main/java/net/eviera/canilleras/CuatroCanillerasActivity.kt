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

        val plantillaFondoBlanco = ContextCompat.getDrawable(this, R.drawable.prueba_plantilla_fondo_blanco)
        val pele = ContextCompat.getDrawable(this, R.drawable.pele)

        val layers = arrayOf<Drawable?>(pele, plantillaFondoBlanco)
        val layerDrawable = LayerDrawable(layers)
        plantilla_arr_izq.scaleType = ImageView.ScaleType.FIT_CENTER
        plantilla_arr_izq.setImageDrawable(layerDrawable)

        //frut
        plantilla_arr_der.setImageDrawable(plantillaFondoBlanco)
        plantilla_abj_izq.setImageDrawable(plantillaFondoBlanco)
        plantilla_abj_der.setImageDrawable(plantillaFondoBlanco)

    }
}
