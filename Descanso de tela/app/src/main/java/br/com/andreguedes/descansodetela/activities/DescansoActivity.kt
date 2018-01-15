package br.com.andreguedes.descansodetela.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.support.v4.app.Fragment
import br.com.andreguedes.descansodetela.FragmentFinishCallback
import br.com.andreguedes.descansodetela.Media
import br.com.andreguedes.descansodetela.MediaData
import br.com.andreguedes.descansodetela.R
import br.com.andreguedes.descansodetela.fragments.ImageFragment
import br.com.andreguedes.descansodetela.fragments.VideoFragment
import kotlinx.android.synthetic.main.activity_descanso.*
import java.io.Serializable

class DescansoActivity : AppCompatActivity(), Serializable, FragmentFinishCallback {

    private var medias: List<Media> = MediaData.getMedias(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).absolutePath)

    private var position: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_descanso)

        root.setOnClickListener {
            finish()
        }

        next()
    }

    override fun next() {
        if (position < medias.size) {
            val media = medias[position]
            if (media.type == "video") {
                replaceFragment(VideoFragment(this, media))
            } else {
                replaceFragment(ImageFragment(this, media))
            }

            position++
        } else {
            position = 0
            next()
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.frmContainer, fragment).commit()
    }

}