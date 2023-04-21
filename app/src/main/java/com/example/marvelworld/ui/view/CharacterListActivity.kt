package com.example.marvelworld.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.marvelworld.core.RetrofitHelper
import com.example.marvelworld.data.model.CharacterModel

import com.example.marvelworld.data.model.DataModel
import com.example.marvelworld.data.model.ResultsModel

import com.example.marvelworld.data.network.ApiClient
import com.example.marvelworld.databinding.ActivityCharacterListBinding
import com.example.marvelworld.ui.CharacterAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit

class CharacterListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCharacterListBinding
    private lateinit var adapter: CharacterAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCharacterListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        RetrofitHelper.getRetrofit()
        initUI()
    }

    private fun initUI() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
        override fun onQueryTextSubmit(query: String?): Boolean {
            searchByName(query.orEmpty())
            return false
        }

        override fun onQueryTextChange(newText: String?) = false
    })

        adapter = CharacterAdapter (  )
        binding.rvCharacter.setHasFixedSize(true)
        binding.rvCharacter.layoutManager = LinearLayoutManager(this)
        binding.rvCharacter.adapter = adapter
    }

    private fun searchByName(query: String) {
           binding.progressBar.isVisible = true
            CoroutineScope(Dispatchers.IO).launch {
                val retrofit = RetrofitHelper.getRetrofit()
                val call: Response<CharacterModel<DataModel>> =
                    retrofit.create(ApiClient::class.java).getCharacters(query)
                if (call.isSuccessful) {
                    val response: CharacterModel<DataModel>? = call.body()
                    Log.i("aristidevs", "funciona :)")
                    if (response != null) {
                        Log.i("aristidevs", response.toString())
                        runOnUiThread {
                           // adapter.updateList(List)

                            binding.progressBar.isVisible = false
                        }
                    }
                } else {
                    Log.i("aristidevs", "No funciona :(")
                }
            }
        }

    }
