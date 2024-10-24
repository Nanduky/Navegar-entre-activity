package com.nanduky.cursokotlindesde0.consumodeapi

import com.google.gson.annotations.SerializedName

data class DogsRespuestaDataClass(
    @SerializedName("status") var status: String,
    @SerializedName("message") var imagenessDogDRDC: List<String>
)