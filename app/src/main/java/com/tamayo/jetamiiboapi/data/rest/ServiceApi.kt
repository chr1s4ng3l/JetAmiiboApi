package com.tamayo.jetamiiboapi.data.rest

import com.tamayo.jetamiiboapi.data.model.ItemsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ServiceApi {

    @GET(ITEMS)
    suspend fun getItems(
    ):Response<ItemsResponse>



    companion object{


        const val BASE_URL = "https://www.amiiboapi.com/api/"
        const val ITEMS = "amiibo/"
    }

}