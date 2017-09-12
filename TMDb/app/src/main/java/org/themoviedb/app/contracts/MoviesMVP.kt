package org.themoviedb.app.contracts

/**
 * Created by Andre on 11/09/17.
 */
interface MoviesMVP {

    interface MoviesModelImpl {
        fun getMovies()
    }

    interface MoviesViewImpl {
        fun showResult(result: String)
    }

    interface MoviesPresenterImpl {
        fun getMovies()
    }

}