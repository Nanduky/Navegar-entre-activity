package com.nanduky.cursokotlindesde0.superheroapp

import com.google.gson.annotations.SerializedName

data class SuperHeroDataClassDetallesResponse(
    @SerializedName("name") val nombreSuperSHDCDR: String,
    @SerializedName("powerstats") val powerstatsSuperSHDCDR: PowerStarItemResponse,
    @SerializedName("image") val imageSuperSHDCDR: ImageSuperResponse,
    @SerializedName("biography") val biografiaSHDCDR: BiographySuperResponse,
    @SerializedName("appearance") val appearanceSHDCDR: AppearanceSuperResponse
)

data class PowerStarItemResponse(
    @SerializedName("intelligence") val inteligencia: String,
    @SerializedName("strength") val fuerza: String,
    @SerializedName("speed") val velocidad: String,
    @SerializedName("durability") val durabilidad: String,
    @SerializedName("power") val poder: String,
    @SerializedName("combat") val combate: String,
)

data class ImageSuperResponse(
    @SerializedName("url") val urlImageSuper: String
)

data class BiographySuperResponse(
    @SerializedName("full-name") val nombreReal: String,
    @SerializedName("publisher") val editorial: String
)

data class AppearanceSuperResponse(
    @SerializedName("gender") val generoSuper: String,
    @SerializedName("race") val razaSuper: String,
    @SerializedName("height") val alturaSuper: List<String>,
    @SerializedName("weight") val pesoSuper: List<String>
)

