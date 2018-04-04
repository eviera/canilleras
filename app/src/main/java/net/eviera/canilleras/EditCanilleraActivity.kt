package net.eviera.canilleras

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.View
import com.flask.colorpicker.ColorPickerView
import com.flask.colorpicker.builder.ColorPickerDialogBuilder
import kotlinx.android.synthetic.main.activity_edit_canillera.*
import net.eviera.canilleras.view.motionview.MotionView
import net.eviera.canilleras.view.motionview.TextEditorDialogFragment
import net.eviera.canilleras.view.motionview.adapter.FontsAdapter
import net.eviera.canilleras.view.motionview.entity.ImageEntity
import net.eviera.canilleras.view.motionview.entity.MotionEntity
import net.eviera.canilleras.view.motionview.entity.TextEntity
import net.eviera.canilleras.view.motionview.utils.FontProvider
import net.eviera.canilleras.view.motionview.viewmodel.Layer
import net.eviera.canilleras.view.motionview.viewmodel.TextLayer


class EditCanilleraActivity : BaseActivity(), TextEditorDialogFragment.OnTextLayerCallback {

    private val PICK_IMAGE = 1
    private lateinit var fontProvider: FontProvider

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_canillera)

        btnGaleria.setOnClickListener {
            val pickIntent = Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            pickIntent.type = "image/*"
            startActivityForResult(pickIntent, PICK_IMAGE)
        }

        fontProvider = FontProvider(resources)

        plantillaView.setMotionViewCallback(object : MotionView.MotionViewCallback {
            override fun onEntitySelected(entity: MotionEntity?) {
                if (entity is TextEntity) {
                    textEntityEditPanel.visibility = View.VISIBLE
                } else {
                    textEntityEditPanel.visibility = View.GONE
                }
            }

            override fun onEntityDoubleTap(entity: MotionEntity) {
                startTextEntityEditing()
            }

        })

        textEntityEditPanel.visibility = View.GONE

        initTextEntitiesListeners()
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


    private fun addSticker(bitmap: Bitmap) {
        plantillaView.post({
            val entity = ImageEntity(Layer(), bitmap, plantillaView.width, plantillaView.height)
            plantillaView.addEntityAndPosition(entity)
        })
    }

    private fun initTextEntitiesListeners() {
        text_entity_font_size_increase.setOnClickListener({ increaseTextEntitySize() })
        text_entity_font_size_decrease.setOnClickListener({ decreaseTextEntitySize() })
        text_entity_color_change.setOnClickListener({ changeTextEntityColor() })
        text_entity_font_change.setOnClickListener({ changeTextEntityFont() })
        text_entity_edit.setOnClickListener({ startTextEntityEditing() })
    }

    private fun increaseTextEntitySize() {
        val textEntity = currentTextEntity()
        if (textEntity != null) {
            textEntity.layer.font.increaseSize(TextLayer.Limits.FONT_SIZE_STEP)
            textEntity.updateEntity()
            plantillaView.invalidate()
        }
    }

    private fun decreaseTextEntitySize() {
        val textEntity = currentTextEntity()
        if (textEntity != null) {
            textEntity.layer.font.decreaseSize(TextLayer.Limits.FONT_SIZE_STEP)
            textEntity.updateEntity()
            plantillaView.invalidate()
        }
    }

    private fun changeTextEntityColor() {
        val textEntity = currentTextEntity() ?: return

        val initialColor = textEntity.layer.font.color

        ColorPickerDialogBuilder
                .with(this@EditCanilleraActivity)
                .setTitle(R.string.select_color)
                .initialColor(initialColor)
                .wheelType(ColorPickerView.WHEEL_TYPE.CIRCLE)
                .density(8) // magic number
                .setPositiveButton(R.string.ok) { _, selectedColor, _ ->
                    textEntity.layer.font.color = selectedColor
                    textEntity.updateEntity()
                    plantillaView.invalidate()
                }
                .setNegativeButton(R.string.cancel, { _, _ -> })
                .build()
                .show()
    }

    private fun changeTextEntityFont() {
        val fonts = fontProvider.fontNames
        val fontsAdapter = FontsAdapter(this, fonts, fontProvider)
        AlertDialog.Builder(this)
                .setTitle(R.string.select_font)
                .setAdapter(fontsAdapter, { _, which ->
                    val textEntity = currentTextEntity()
                    if (textEntity != null) {
                        textEntity.layer.font.typeface = fonts[which]
                        textEntity.updateEntity()
                        plantillaView.invalidate()
                    }
                })
                .show()
    }

    private fun startTextEntityEditing() {
        val textEntity = currentTextEntity()
        if (textEntity != null) {
            val fragment = TextEditorDialogFragment.getInstance(textEntity.layer.text)
            fragment.show(fragmentManager, TextEditorDialogFragment::class.java.name)
        }
    }

    private fun currentTextEntity(): TextEntity? {
        return if (plantillaView != null && plantillaView.selectedEntity is TextEntity) {
            plantillaView.selectedEntity as TextEntity?
        } else {
            null
        }
    }

    override fun textChanged(text: String) {
        val textEntity = currentTextEntity()
        if (textEntity != null) {
            val textLayer = textEntity.layer
            if (text != textLayer.text) {
                textLayer.text = text
                textEntity.updateEntity()
                plantillaView.invalidate()
            }
        }
    }


}
