package net.eviera.canilleras

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Environment
import android.os.Environment.getExternalStorageDirectory
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.itextpdf.text.Document
import com.itextpdf.text.Paragraph
import com.itextpdf.text.pdf.PdfWriter
import java.io.File
import java.io.FileOutputStream

class BORRARPdf : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_borrarpdf)
    }

    private val MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE: Int = 0

    fun pdf(v: View) {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "pide permisos", Toast.LENGTH_SHORT).show()

            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE), MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE)

        } else {
            writePDF()
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        when (requestCode) {
            MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE -> {

                // If request is cancelled, the result arrays are empty.
                if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    Toast.makeText(this, "permisos enableados", Toast.LENGTH_SHORT).show()

                    writePDF()

                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.

                } else {

                    Toast.makeText(this, "permisos no permitidos", Toast.LENGTH_SHORT).show()

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.

                }
                return
            }
            else -> {
                // Ignore all other requests.
            }
        }
    }

    private fun writePDF() {
        Toast.makeText(this, "write pdf", Toast.LENGTH_SHORT).show()
        val document = Document();
        val file = File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "HelloCanilleras.pdf")
        PdfWriter.getInstance(document, FileOutputStream(file));
        document.open();
        val p = Paragraph("Hello PDF");
        document.add(p);
        document.close();

    }
}
