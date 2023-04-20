package com.example.marvelworld.ui

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.marvelworld.data.model.Results
import com.example.marvelworld.databinding.ItemCharacterBinding

class CharacterViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private val binding = ItemCharacterBinding.bind(view)

    fun bind(results: Results){
        binding.tvSuperheroName.text = results.characterName
    }
}