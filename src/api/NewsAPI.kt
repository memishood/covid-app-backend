package com.covidapp.api

/**
 * @author emremms35@gmail.com
 */

import com.covidapp.model.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Headers

interface NewsAPI {
    @GET("corona/coronaNews")
    @Headers(
        "content-type: application/json",
        "authorization: apikey 4bGOQR3l2SsqK8uT3rwKN1:6u3nyC2bSmnTK6guoTP3s4"
    )
    suspend fun getNews(): NewsResponse?
}