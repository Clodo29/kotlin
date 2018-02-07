package br.com.andreguedes.descansodetela

/**
 * Created by andreguedes on 10/01/18.
 */
class Media(val path: String, val type: String, val duration: Long?)

object MediaData {

    fun getMedias(pathToDir: String): ArrayList<Media> {
        val m1 = Media(pathToDir + "/video.mp4", "video", null)
        val m2 = Media(pathToDir + "/image1.jpg", "img", 2000)
        val m3 = Media(pathToDir + "/image2.jpg", "img", 2000)
        val m4 = Media(pathToDir + "/image3.jpg", "img", 2000)

        return arrayListOf(m1, m2, m3, m4)
    }

}