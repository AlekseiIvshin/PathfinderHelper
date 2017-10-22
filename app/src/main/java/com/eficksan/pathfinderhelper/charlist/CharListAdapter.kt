package com.eficksan.pathfinderhelper.charlist

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.eficksan.pathfinderhelper.R
import com.eficksan.pathfinderhelper.models.Character

/**
 * Created by Aleksei on 19.10.2017.
 */
class CharListAdapter(private val itemListener: CharListItemViewHolder.ItemListener) : RecyclerView.Adapter<CharListItemViewHolder>() {

    var characters: List<Character>? = null

    override fun getItemCount(): Int = characters?.size ?: 0

    override fun onBindViewHolder(holder: CharListItemViewHolder?, position: Int) {
        holder?.updateContent(characters!![position])
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CharListItemViewHolder =
            CharListItemViewHolder(LayoutInflater.from(parent!!.context).inflate(R.layout.item_character, parent, false), itemListener)

    fun updateItems(tasks: List<Character>?) {
        characters = tasks
        notifyDataSetChanged()
    }
}