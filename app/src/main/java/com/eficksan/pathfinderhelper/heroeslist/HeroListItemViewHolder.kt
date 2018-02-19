package com.eficksan.pathfinderhelper.heroeslist

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.eficksan.pathfinderhelper.R
import com.eficksan.pathfinderhelper.models.Hero

/**
 * Created by Aleksei
 * on 19.10.2017.
 */
class HeroListItemViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
    private val charName: TextView = itemView!!.findViewById(R.id.tv_hero_name) as TextView

    fun updateContent(hero: Hero, itemClickListener: OnItemClickListener) {
        charName.text = hero.name

        itemView.setOnClickListener { itemClickListener.onHeroClicked(hero) }
    }

    interface OnItemClickListener {
        fun onHeroClicked(hero: Hero)
    }
}