package org.themoviedb.app.service.api

import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Andre on 11/09/17.
 */
interface BaseAPI {

    companion object {
        val BASE: String get() = "https://api.themoviedb.org/3/"
        val API_KEY: String get() = "604787055d3230bf4777b4f32c5d9683"
    }

    @GET("discover/movie")
    fun getMovies(@Query("api_key") apiKey: String)

}