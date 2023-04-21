package com.example.marvelworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.marvelworld.databinding.ActivityCharacterDetailBinding


class CharacterDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCharacterDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCharacterDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}