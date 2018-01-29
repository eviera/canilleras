package net.eviera.canilleras

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.zxing.integration.android.IntentIntegrator
import net.eviera.canilleras.util.Global.EXTRA_START_SCAN_QR

class ScanQRLauncherActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val isStartScanQR = intent.getBooleanExtra(EXTRA_START_SCAN_QR, false)
        if (isStartScanQR) {
            initScan()
        } else {
            initView()
        }

    }

    private fun initView() {
        setContentView(R.layout.activity_scan_qrlauncher)
    }

    private fun initScan() {
        val integrator = IntentIntegrator(this)
        integrator.setOrientationLocked(false)
        integrator.captureActivity = ScanQRActivity::class.java
        integrator.initiateScan()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == IntentIntegrator.REQUEST_CODE) {
            val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
            if (result != null) {
                if (result.contents != null) {
                    //FIXME cheuquear qu el contenido sea valido
                    val qrScanResult = result.contents

                    println("QR LLego: " + qrScanResult)

                    //FIXME si todo esta bien, navega al menu
                    val menuActivity = Intent(this, MenuActivity::class.java)
                    startActivity(menuActivity)

                } else {
                    initView()
                    Toast.makeText(this, R.string.codigo_qr_invalido, Toast.LENGTH_SHORT).show()
                }

            } else run {
                initView()
                Toast.makeText(this, R.string.cancelado, Toast.LENGTH_SHORT).show()

            }

        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }

    fun retryScan(view: View) {
        initScan()
    }

}
