package com.example.marvelworld.data.network


import androidx.room.util.query
import com.example.marvelworld.core.RetrofitHelper
import com.example.marvelworld.data.model.CharacterModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/*class Service {
    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getCharacters(): List<CharacterModel> {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(ApiClient::class.java).getCharacters()
            response.body() ?: emptyList()
        }
    }
}*/

