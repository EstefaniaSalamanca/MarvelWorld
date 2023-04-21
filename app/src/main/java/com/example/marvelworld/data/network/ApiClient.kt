package com.example.marvelworld.data.network



import com.example.marvelworld.CharacterDetailModel
import com.example.marvelworld.data.model.CharacterModel
import com.example.marvelworld.data.model.DataModel
import com.example.marvelworld.data.model.ResultsModel

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

import retrofit2.http.Query

interface ApiClient {
    @GET("/v1/public/characters?ts=1&apikey=4dc1b141446d7991b4e54a55fc103bf7&hash=710b5b7151872e980d79f983bcb6331d")
    suspend fun getCharacters(@Query("nameStartsWith") characterName: String): Response<CharacterModel<DataModel>>

    @GET("/v1/public/characters/{characterId}?ts=1&apikey=4dc1b141446d7991b4e54a55fc103bf7&hash=710b5b7151872e980d79f983bcb6331d")
    suspend fun getCharacterDetail(@Path("characterId") characterId:String): Response<CharacterDetailModel>


}