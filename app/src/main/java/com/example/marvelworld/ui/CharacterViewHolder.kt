package com.example.marvelworld.ui

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.marvelworld.data.model.DataModel


import com.example.marvelworld.data.model.ResultsModel
import com.example.marvelworld.databinding.ItemCharacterBinding

class CharacterViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private val binding = ItemCharacterBinding.bind(view)

    fun bind(resultsModel: ResultsModel){
        binding.tvSuperheroName.text = resultsModel.characterName
    }
}