package net.eviera.canilleras

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
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

    }

    fun seleccionarCanillera(view: View) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(R.string.elija_un_tipo)
        val adapter = ArrayAdapter<Global.TipoCanillera>(this, android.R.layout.simple_list_item_1, Global.TipoCanillera.values())
        builder.setSingleChoiceItems(adapter, 0, { dialog, which ->
            val selectedItem = Global.TipoCanillera.values()[which]

            //Guardo la seleccion en la session
            session.tipoCanillera = selectedItem

            //Muestro la seleccion
            Toast.makeText(this, resources.getString(R.string.seleccionado) + " " + selectedItem, Toast.LENGTH_SHORT).show()
            dialog.dismiss()

            //Navego hacia el menu al seleccionar
            val menuActivity = Intent(this@ScanQRActivity, MenuActivity::class.java)
            startActivity(menuActivity)

        })
        builder.show()
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
