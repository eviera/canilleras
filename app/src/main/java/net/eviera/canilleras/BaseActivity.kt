package net.eviera.canilleras

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.include_logo.*
import net.eviera.canilleras.manager.CaniApp
import net.eviera.canilleras.manager.Session

open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onStart() {
        super.onStart()

        //Intento pintar el texto del tipo de canillera que esta en el logo
        val logoView = findViewById<View>(R.id.logo);
        if (logoView != null) {
            val logoTipoModelo = logoView.findViewById<TextView>(R.id.logo_tipo_modelo);
            if (logoTipoModelo != null && session.tipoCanillera != null) {
                logoTipoModelo.text = session.tipoCanillera.toString();
            }
        }
    }

    /**
     * Overrides the pending Activity transition by performing the "Enter" animation.
     */
    protected fun transitionSlideEnter() {
        overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left)
    }

    /**
     * Overrides the pending Activity transition by performing the "Exit" animation.
     */
    protected fun transitionSlideExit() {
        overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right)
    }

    protected fun transitionZoomExit() {
        overridePendingTransition(R.anim.zoom_enter, R.anim.zoom_exit)
    }


    val session : Session
        get() {
            val caniApp = (application as? CaniApp)
            if (caniApp == null) {
                throw RuntimeException("La aplicacion no se inicializo correctamente")
            } else {
                return caniApp.session
            }
        }

}