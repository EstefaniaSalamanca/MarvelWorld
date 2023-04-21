package com.example.marvelworld.data.model

import com.google.gson.annotations.SerializedName

data class CharacterModel<DataModel>(
    @SerializedName("status") val status: String,
    @SerializedName("data") val data: DataModel?
)

data class DataModel(
    @SerializedName("results") val results: List<ResultsModel>,
)

data class ResultsModel(
    @SerializedName("id") val characterId: Int,
    @SerializedName("name") val characterName: String,
    @SerializedName("thumbnail") val image: Thumbnail,
)

data class Thumbnail(
    @SerializedName("extension") val extension: String,
    @SerializedName("path") val path: String
)