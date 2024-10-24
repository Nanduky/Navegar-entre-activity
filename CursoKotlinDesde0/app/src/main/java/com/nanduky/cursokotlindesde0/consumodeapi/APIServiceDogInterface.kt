package com.nanduky.cursokotlindesde0.consumodeapi

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface APIServiceDogInterface {
    @GET
    suspend fun getDogsPorRaza(@Url url:String ):Response<DogsRespuestaDataClass>
}