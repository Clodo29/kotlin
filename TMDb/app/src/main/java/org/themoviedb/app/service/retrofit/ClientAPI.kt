package org.themoviedb.app.service.retrofit

import okhttp3.Cache
import okhttp3.OkHttpClient
import org.themoviedb.app.TMDbApplication
import org.themoviedb.app.service.api.BaseAPI
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by Andre on 11/09/17.
 */
object ClientAPI {

    private var retrofit: Retrofit? = null

    fun getClient(): Retrofit {
        val cache = Cache(TMDbApplication.getFileCacheDir(), (10 * 1024 * 1024).toLong())

        val client = OkHttpClient.Builder()
                .readTimeout(20, TimeUnit.SECONDS)
                .connectTimeout(20, TimeUnit.SECONDS)
                .cache(cache)
                .addInterceptor { chain ->
                    var request = chain.request()
                    if (TMDbApplication.isNetworkAvailable()) {
                        request = request.newBuilder().header("Cache-Control", "public, max-age=" + 60).build()
                    } else {
                        request = request.newBuilder().header("Cache-Control", "public, only-if-cached, max-stale=" + 60 * 60 * 24 * 7).build()
                    }
                    chain.proceed(request)
                }
                .build()

        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                    .baseUrl(BaseAPI.BASE)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build()
        }
        return retrofit!!
    }

}