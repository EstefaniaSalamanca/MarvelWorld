package com.example.marvelworld.data.model

import com.google.gson.annotations.SerializedName

data class CharacterModel(
    @SerializedName ("status") val status: String,
    @SerializedName ("data") val data: Data
)
data class Data(
    @SerializedName ("results") val characters: List<Results>,
)
data class Results(
    @SerializedName ("id") val characterId: Int,
    @SerializedName ("name")val characterName: String,
    @SerializedName ("thumbnail") val image: Thumbnail,
)
data class Thumbnail(
    @SerializedName ("extension") val extension: String,
    @SerializedName ("path") val path: String
)