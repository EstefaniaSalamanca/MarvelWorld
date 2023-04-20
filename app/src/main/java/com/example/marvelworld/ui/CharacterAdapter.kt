package com.example.marvelworld.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.marvelworld.R
import com.example.marvelworld.data.model.Results

class CharacterAdapter (
    var characterList: List<Results> = emptyList()) :
    RecyclerView.Adapter<CharacterViewHolder>() {

    fun updateList(characterList:List<Results>){
        this.characterList=characterList
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        return CharacterViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_character, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(characterList[position])
    }

    override fun getItemCount() = characterList.size

    }


