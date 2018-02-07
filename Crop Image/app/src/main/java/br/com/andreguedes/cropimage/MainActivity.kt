package br.com.andreguedes.cropimage

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.support.v7.app.AppCompatActivity
import com.theartofdev.edmodo.cropper.CropImage
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File
import java.io.IOException

class MainActivity : AppCompatActivity() {

    private val REQ_CODE_PICK_IMAGE = 1
    private val TEMP_PHOTO_FILE = "temporary_holder.png"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_load.setOnClickListener {
            val photoPickerIntent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            photoPickerIntent.type = "image/*"
            photoPickerIntent.putExtra("aspectX", 1)
            photoPickerIntent.putExtra("aspectY", 1)
            photoPickerIntent.putExtra("outputX", 1024)
            photoPickerIntent.putExtra("outputY", 1024)
            photoPickerIntent.putExtra("return-data", true)
            photoPickerIntent.putExtra("scaleUpIfNeeded", true)
            photoPickerIntent.putExtra(MediaStore.EXTRA_OUTPUT, getTempUri())
            photoPickerIntent.putExtra("outputFormat", Bitmap.CompressFormat.PNG.toString())
            startActivityForResult(photoPickerIntent, REQ_CODE_PICK_IMAGE)
        }
    }

    private fun getTempUri(): Uri {
        return Uri.fromFile(getTempFile())
    }

    private fun getTempFile(): File? {
        return if (Environment.getExternalStorageState() == Environment.MEDIA_MOUNTED) {
            val file = File(Environment.getExternalStorageDirectory(), TEMP_PHOTO_FILE)
            try {
                file.createNewFile()
            } catch (e: IOException) {
            }

            file
        } else {
            null
        }
    }

    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        super.onActivityResult(requestCode, resultCode, data)

        when (requestCode) {
            REQ_CODE_PICK_IMAGE ->
                if (resultCode == Activity.RESULT_OK) {

                    if (data != null) {
                        CropImage.activity(data.data)
                                .setAspectRatio(1, 1)
                                .start(this)
                    }
                }
            CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE -> {
                val result = CropImage.getActivityResult(data)
                if (resultCode == RESULT_OK) {
                    var resultUri = result.uri
                    img_result.setImageURI(resultUri)
                } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                    var error = result.error
                }
            }
        }
    }

}