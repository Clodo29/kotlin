package br.com.andreguedes.descansodetela.fragments

import android.annotation.SuppressLint
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.andreguedes.descansodetela.FragmentFinishCallback
import br.com.andreguedes.descansodetela.Media
import br.com.andreguedes.descansodetela.R
import kotlinx.android.synthetic.main.fragment_video.*

@SuppressLint("ValidFragment")
/**
 * A simple [Fragment] subclass.
 */
class VideoFragment(private val listener: FragmentFinishCallback, private val media: Media) : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_video, container, false)
    }

    override fun onResume() {
        super.onResume()

        video.setVideoURI(Uri.parse(media.path))
        video.start()

        video.setOnCompletionListener {
            listener.next()
        }
    }

}