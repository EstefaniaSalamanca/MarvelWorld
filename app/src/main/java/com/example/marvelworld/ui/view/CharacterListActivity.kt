package com.example.marvelworld.ui.view

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.marvelworld.R
import com.example.marvelworld.ui.view.CharacterDetailActivity.Companion.EXTRA_ID
import com.example.marvelworld.core.RetrofitHelper
import com.example.marvelworld.data.model.CharacterModel
import com.example.marvelworld.data.model.DataModel
import com.example.marvelworld.data.network.ApiClient
import com.example.marvelworld.databinding.ActivityCharacterListBinding
import com.example.marvelworld.ui.CharacterAdapter
import com.google.android.material.internal.ViewUtils.hideKeyboard
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response


class CharacterListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCharacterListBinding
    private lateinit var adapter: CharacterAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCharacterListBinding.inflate(layoutInflater)
        setContentView(binding.root)
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

        adapter = CharacterAdapter { navigateToDetail(it) }
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
                Log.i("estefania", "funciona :)")
                if (response != null) {
                    Log.i("estefania", response.toString())
                    runOnUiThread {
                        response.data?.let { adapter.updateList(it.results) }

                        binding.progressBar.isVisible = false
                    }
                }
            } else {
                Log.i("estefania", "No funciona :(")
            }
            hideKeyboard()
        }
    }
    private fun hideKeyboard() {
        val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(binding.viewRoot.windowToken, 0)
    }



    private fun navigateToDetail(id: Int) {
        val intent = Intent(this, CharacterDetailActivity::class.java)
        intent.putExtra(EXTRA_ID, id)
        startActivity(intent)

    }


}

