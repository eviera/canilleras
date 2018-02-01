package net.eviera.canilleras

import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import net.eviera.canilleras.manager.CaniApp
import net.eviera.canilleras.manager.Session
import net.eviera.canilleras.util.Global

open class BaseActivity : AppCompatActivity() {

    /**
     * Overrides the pending Activity transition by performing the "Enter" animation.
     */
    protected fun overridePendingTransitionEnter() {
        overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left)
    }

    /**
     * Overrides the pending Activity transition by performing the "Exit" animation.
     */
    protected fun overridePendingTransitionExit() {
        overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right)
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

    /**
     * Hace el setup del combo de selección de tipo de canillera
     */
    protected fun setupTipoCanilleraSpinner(spnTipoCanillera: Spinner) {
        val tipoCanilleraAdapter = ArrayAdapter<Global.TipoCanillera>(this, android.R.layout.simple_spinner_item, Global.TipoCanillera.values())
        spnTipoCanillera.adapter = tipoCanilleraAdapter
        if (session.tipoCanillera != null) {
            spnTipoCanillera.setSelection(tipoCanilleraAdapter.getPosition(session.tipoCanillera))
        }
        spnTipoCanillera.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                session.tipoCanillera = spnTipoCanillera.selectedItem as Global.TipoCanillera?
            }
            override fun onNothingSelected(parent: AdapterView<*>) {
                session.tipoCanillera = null
            }
        }
    }

}