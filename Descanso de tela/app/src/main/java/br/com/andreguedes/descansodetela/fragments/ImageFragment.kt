package br.com.andreguedes.descansodetela.fragments

import android.annotation.SuppressLint
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.andreguedes.descansodetela.FragmentFinishCallback
import br.com.andreguedes.descansodetela.Media
import br.com.andreguedes.descansodetela.R
import kotlinx.android.synthetic.main.fragment_image.*

@SuppressLint("ValidFragment")
/**
 * A simple [Fragment] subclass.
 */
class ImageFragment(private val listener: FragmentFinishCallback, private val media: Media) : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_image, container, false)
    }

    override fun onResume() {
        super.onResume()

        img.setImageURI(Uri.parse(media.path))

        Handler().postDelayed({ listener.next() }, media.duration!!)
    }

}