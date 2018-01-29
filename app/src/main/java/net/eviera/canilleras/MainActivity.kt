package net.eviera.canilleras

import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import net.eviera.canilleras.util.Global.EXTRA_START_SCAN_QR

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnIniciar.setOnClickListener {
            val scanQRLauncherActivity = Intent(this, ScanQRLauncherActivity::class.java)
            scanQRLauncherActivity.putExtra(EXTRA_START_SCAN_QR, true)
            startActivity(scanQRLauncherActivity)
            overridePendingTransitionEnter()
        }
    }
}
