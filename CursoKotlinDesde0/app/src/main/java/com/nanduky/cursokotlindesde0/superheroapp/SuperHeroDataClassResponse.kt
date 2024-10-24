package com.nanduky.cursokotlindesde0.superheroapp

import com.google.gson.annotations.SerializedName

data class SuperHeroDataClassResponse(
    @SerializedName("response") val respuestaSHDCR: String,
    @SerializedName("results") val resultadoSuperHeroeSHDCR: List<SuperHeroItemDataClassResponse>
)

/** data class hijo del data class SuperHeroDataClassResponse */
data class SuperHeroItemDataClassResponse(
    @SerializedName("id") val superHeroId: String,
    @SerializedName("name") val superHeroNombre: String,
    /** item para pasar la url de la imagen al adapter */
    @SerializedName("image") val superHeroImage: SuperHeroImageDataClassResponse
)

/** Nueva data class para recuperar la url de la imagen */
data class SuperHeroImageDataClassResponse(
    @SerializedName("url") val urlImage : String
)


