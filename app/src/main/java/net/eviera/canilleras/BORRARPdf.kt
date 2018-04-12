package net.eviera.canilleras

import android.Manifest
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.os.Environment
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.itextpdf.text.*
import com.itextpdf.text.pdf.PdfName
import com.itextpdf.text.pdf.PdfWriter
import java.io.ByteArrayOutputStream
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
        val document = Document(PageSize.A4);

        val file = File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "HelloCanilleras.pdf")
        val writer = PdfWriter.getInstance(document, FileOutputStream(file));
        writer.addViewerPreference(PdfName.PRINTSCALING, PdfName.NONE);
        document.open();

        val d = ContextCompat.getDrawable(this, R.drawable.pele)
        val bmp = (d as BitmapDrawable).bitmap
        val stream = ByteArrayOutputStream()
        bmp.compress(Bitmap.CompressFormat.PNG, 100, stream)
        val image = Image.getInstance(stream.toByteArray())
        image.setAbsolutePosition(100f, 100f)
        image.scaleAbsolute(Utilities.millimetersToPoints(50f), Utilities.millimetersToPoints(50f))
        document.add(image)

        val p = Paragraph("Hello PDF");
        document.add(p);

        createRectangle(writer, 30.75f, 11f, 148.5f, 210f, BaseColor.RED);

        document.close();

    }

    private fun createRectangle(writer: PdfWriter, x: Float, y: Float, width: Float, height: Float, color: BaseColor) {
        val posX = Utilities.millimetersToPoints(x)
        val posY = Utilities.millimetersToPoints(y)

        val widthX = Utilities.millimetersToPoints(width + x)
        val heightY = Utilities.millimetersToPoints(height + y)

        val rectangle = Rectangle(posX, posY, widthX, heightY)

        val canvas = writer.directContent
        rectangle.border = Rectangle.BOX
        rectangle.borderWidth = 1f
        rectangle.borderColor = color
        canvas.rectangle(rectangle)

    }

}
