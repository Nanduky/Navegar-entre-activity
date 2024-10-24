package com.nanduky.cursokotlindesde0.superheroapp

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiServiceSuperInterface {
    //https://superheroapi.com/api/access-token/search/name
    /** Identificamos el tipo de llamada que vamos a hacer. Esta API sólo tiene GET */
    @GET("/api/3609252f23e4fc59e44367838366f23b/search/{nombre}")
    /** https://superheroapi.com/ -> en retrofit de SuperHeroListActivity */
    /** Aquí no son private, sino que son suspend */
    suspend fun getSuperHeroInterface(@Path("nombre") superHeroNombreInterface: String):
            Response<SuperHeroDataClassResponse>

    //https://superheroapi.com/api/access-token/character-id
    @GET("/api/3609252f23e4fc59e44367838366f23b/{idSuperHero}")
    /** https://superheroapi.com/ -> en retrofit de DetallesSuperHeroActivity */
    suspend fun getSuperHeroIdInterface(@Path("idSuperHero") superHeroIdInterface: String):
            Response<SuperHeroDataClassDetallesResponse>
}