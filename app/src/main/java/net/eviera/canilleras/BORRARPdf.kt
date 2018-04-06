package net.eviera.canilleras

import android.content.Context
import android.os.Bundle
import android.os.Environment
import android.os.Environment.getExternalStorageDirectory
import android.support.v7.app.AppCompatActivity
import android.view.View
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

    fun pdf(v: View) {
        val document = Document();
        val file = File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "HelloCanilleras.pdf")
        PdfWriter.getInstance(document, FileOutputStream(file));
        document.open();
        val p = Paragraph("Hello PDF");
        document.add(p);
        document.close();
    }
}
