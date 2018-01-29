package net.eviera.canilleras

import android.support.v7.app.AppCompatActivity
import net.eviera.canilleras.manager.CaniApp
import net.eviera.canilleras.manager.Session

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
}