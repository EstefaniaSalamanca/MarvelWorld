package com.example.marvelworld.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.marvelworld.CharacterDetailModel

import com.example.marvelworld.ResultDetailModel

import com.example.marvelworld.core.RetrofitHelper


import com.example.marvelworld.data.network.ApiClient
import com.example.marvelworld.databinding.ActivityCharacterDetailBinding
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response


class CharacterDetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_ID = "extra_id"
    }

    private lateinit var binding: ActivityCharacterDetailBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCharacterDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val id = intent.getIntExtra(EXTRA_ID,1)
        getCharactersInformation(id)
    }

    private fun getCharactersInformation(id: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            val retrofit = RetrofitHelper.getRetrofit()
            val characterDetail: Response<CharacterDetailModel> =
                retrofit.create(ApiClient::class.java).getCharacterDetail(id)
            val response: CharacterDetailModel? = characterDetail.body()

            if(response != null){
                Log.i("Estefania", response.toString())

                runOnUiThread {

                    response.data?.let { createUI(it.results) }


                }
            }
        }



    }

        private fun createUI(characters: List<ResultDetailModel>) {
            for (character in characters) {

                Picasso.get().load(character.image.path + "." + character.image.extension).into(binding.ivCharacter)

                binding.tvDescription.text = character.description
            }

    }




}



