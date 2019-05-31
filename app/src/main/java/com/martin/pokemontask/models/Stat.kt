package com.martin.pokemontask.models


import com.google.gson.annotations.SerializedName

data class Stat(
    @SerializedName("base_stat")
    val baseStat: Int = 0,
    @SerializedName("effort")
    val effort: Int = 0,
    @SerializedName("stat")
    val stat: StatX = StatX()
)