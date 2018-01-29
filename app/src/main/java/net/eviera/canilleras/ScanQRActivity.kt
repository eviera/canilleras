package net.eviera.canilleras

import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.journeyapps.barcodescanner.CaptureManager
import kotlinx.android.synthetic.main.activity_scan_qr.*
import net.eviera.canilleras.util.Global

class ScanQRActivity : BaseActivity() {

    private lateinit var capture: CaptureManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scan_qr)

        //Seteo la captura
        capture = CaptureManager(this, barcodeScannerView)
        capture.initializeFromIntent(intent, savedInstanceState)
        capture.decode()


        //Armo el combo de tipos de canilleras y seteo el que esta elegido (si lo esta)
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



    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        return barcodeScannerView.onKeyDown(keyCode, event) || super.onKeyDown(keyCode, event)
    }

    override fun onResume() {
        super.onResume()
        capture.onResume()
    }

    override fun onPause() {
        super.onPause()
        capture.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        capture.onDestroy()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        capture.onSaveInstanceState(outState)
    }


}
