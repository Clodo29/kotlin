package org.themoviedb.app

import android.app.Application
import android.util.Log
import org.themoviedb.app.util.AppUtil
import java.io.File

/**
 * Created by Andre on 11/09/17.
 */
class TMDbApplication: Application() {

    private val TAG = "TMDbApplication"

    override fun onCreate() {
        super.onCreate()

        appInstance = this
    }

    companion object {
        private var appInstance: TMDbApplication? = null

        fun getInstance(): TMDbApplication {
            if (appInstance == null) {
                throw IllegalStateException("Configure a classe de Application no AndroidManifest.xml")
            }
            return appInstance!!
        }

        fun isNetworkAvailable(): Boolean {
            return AppUtil.isNetworkAvailable(TMDbApplication.getInstance().applicationContext)
        }

        fun getFileCacheDir(): File {
            return TMDbApplication.getInstance().getCacheDir()
        }
    }

    override fun onTerminate() {
        super.onTerminate()
        Log.d(TAG, "TMDbApplication.onTerminate()")
    }

}