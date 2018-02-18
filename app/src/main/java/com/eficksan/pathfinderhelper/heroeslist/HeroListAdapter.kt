package com.eficksan.pathfinderhelper.heroeslist

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.eficksan.pathfinderhelper.R
import com.eficksan.pathfinderhelper.models.Hero

/**
 * Created by Aleksei on 19.10.2017.
 */
class HeroListAdapter(private val itemListener: HeroListItemViewHolder.ItemListener) : RecyclerView.Adapter<HeroListItemViewHolder>() {

    var heroes: List<Hero>? = null

    override fun getItemCount(): Int = heroes?.size ?: 0

    override fun onBindViewHolder(holder: HeroListItemViewHolder?, position: Int) {
        holder?.updateContent(heroes!![position])
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): HeroListItemViewHolder =
            HeroListItemViewHolder(LayoutInflater.from(parent!!.context).inflate(R.layout.item_hero, parent, false), itemListener)

    fun updateItems(newHeroes: List<Hero>?) {
        heroes = newHeroes
        notifyDataSetChanged()
    }
}