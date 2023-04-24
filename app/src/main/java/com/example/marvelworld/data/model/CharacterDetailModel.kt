package com.example.marvelworld

import com.google.gson.annotations.SerializedName

data class CharacterDetailModel(
    @SerializedName("data")val data: DataDetailModel,
    @SerializedName("status")val status: String
)
data class DataDetailModel(

    @SerializedName("results") val results: List<ResultDetailModel>,

)

data class ResultDetailModel(
    @SerializedName("description") val description: String,
    @SerializedName("id") val characterId: Int,
    @SerializedName("name") val characterName: String,
    @SerializedName("thumbnail") val image: Thumbnail,

)

data class Thumbnail(
    @SerializedName("path") val path: String,
    @SerializedName("extension") val extension: String
)