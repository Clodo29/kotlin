package org.themoviedb.app.service.retrofit

import org.themoviedb.app.service.api.BaseAPI

/**
 * Created by Andre on 11/09/17.
 */
class ServiceAPI {

    fun getService(): BaseAPI {
        return ClientAPI.getClient().create(BaseAPI::class.java)
    }

}