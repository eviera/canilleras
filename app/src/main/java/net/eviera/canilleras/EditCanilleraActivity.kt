package net.eviera.canilleras

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_edit_canillera.*
import net.eviera.canilleras.view.motionview.entity.ImageEntity
import net.eviera.canilleras.view.motionview.viewmodel.Layer


class EditCanilleraActivity : BaseActivity() {

    private val PICK_IMAGE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_canillera)

        addSticker(R.drawable.pele)

        btnGaleria.setOnClickListener {
            val pickIntent = Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            pickIntent.type = "image/*"
            startActivityForResult(pickIntent, PICK_IMAGE)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == PICK_IMAGE) {
            if (data != null) {
                val dataInputStream = contentResolver.openInputStream(data.data)
                val bitmap = BitmapFactory.decodeStream(dataInputStream)
                addSticker(bitmap)
            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        transitionZoomExit()
    }


    private fun addSticker(stickerResId: Int) {
        plantillaView.post({
            val layer = Layer()
            val pica = BitmapFactory.decodeResource(resources, stickerResId)
            val entity = ImageEntity(layer, pica, plantillaView.width, plantillaView.height)
            plantillaView.addEntityAndPosition(entity)
        })
    }

    private fun addSticker(bitmap: Bitmap) {
        plantillaView.post({
            val entity = ImageEntity(Layer(), bitmap, plantillaView.width, plantillaView.height)
            plantillaView.addEntityAndPosition(entity)
        })
    }

}
