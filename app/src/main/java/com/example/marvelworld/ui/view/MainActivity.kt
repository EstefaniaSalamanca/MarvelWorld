package com.example.marvelworld.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.marvelworld.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnGoIn.setOnClickListener {
            navigateToGameListActivity()
        }
    }


    private fun navigateToGameListActivity() {
        val intent = Intent(this, CharacterListActivity::class.java)
        startActivity(intent)
    }
}
