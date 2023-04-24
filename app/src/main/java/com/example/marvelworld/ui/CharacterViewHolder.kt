package com.example.marvelworld.ui

import android.view.View
import androidx.recyclerview.widget.RecyclerView


import com.example.marvelworld.data.model.ResultsModel
import com.example.marvelworld.databinding.ItemCharacterBinding
import com.squareup.picasso.Picasso


class CharacterViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private val binding = ItemCharacterBinding.bind(view)

    fun bind(resultsModel: ResultsModel, onItemSelected: (Int) -> Unit){
        binding.tvCharacterName.text = resultsModel.characterName

        Picasso.get().load(resultsModel.image.path+"."+resultsModel.image.extension).into(binding.ivSuperhero)

       binding.root.setOnClickListener { onItemSelected(resultsModel.characterId) }
    }
}