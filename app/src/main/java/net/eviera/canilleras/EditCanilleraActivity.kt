package net.eviera.canilleras

import android.graphics.drawable.Drawable
import android.graphics.drawable.LayerDrawable
import android.os.Bundle
import android.support.v4.content.ContextCompat
import kotlinx.android.synthetic.main.activity_edit_canillera.*
import android.content.Intent
import android.R.attr.data
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.view.Gravity


class EditCanilleraActivity : BaseActivity() {

    private val PICK_IMAGE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_canillera)

        val pele = ContextCompat.getDrawable(this, R.drawable.pele)

        plantillaView.setImageDrawable(pele)

        plantillaView.setOnLongClickListener {
            val pickIntent = Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            pickIntent.type = "image/*"
            startActivityForResult(pickIntent, PICK_IMAGE)
            true
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == PICK_IMAGE) {
            if (data != null) {

                //todo mejorar
                val dataInputStream = contentResolver.openInputStream(data.data)
                val bitmapDrawable = BitmapDrawable(resources, BitmapFactory.decodeStream(dataInputStream))
                bitmapDrawable.setAntiAlias(true)
                bitmapDrawable.gravity = Gravity.CENTER
                plantillaView.setImageDrawable(bitmapDrawable)
            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()

        transitionZoomExit()
    }
}
