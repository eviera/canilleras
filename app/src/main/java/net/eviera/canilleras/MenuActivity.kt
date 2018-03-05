package net.eviera.canilleras

import android.content.Intent
import android.os.Bundle
import android.view.View
import net.eviera.canilleras.util.Global

class MenuActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        transitionSlideExit()
    }

    fun cambiarModelo(view: View) {
        //Me voy a a la actividad que escanea el QR
        val scanQRLauncherActivity = Intent(this, ScanQRLauncherActivity::class.java)
        scanQRLauncherActivity.putExtra(Global.EXTRA_START_SCAN_QR, true)
        startActivity(scanQRLauncherActivity)

        transitionSlideExit()
    }
}
