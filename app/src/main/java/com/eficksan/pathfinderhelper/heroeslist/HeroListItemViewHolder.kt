package com.eficksan.pathfinderhelper.heroeslist

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import com.eficksan.pathfinderhelper.R
import com.eficksan.pathfinderhelper.models.Hero

/**
 * Created by Aleksei
 * on 19.10.2017.
 */
class HeroListItemViewHolder(itemView: View?, private val itemListener: ItemListener) : RecyclerView.ViewHolder(itemView) {
    val charName: TextView = itemView!!.findViewById(R.id.tv_hero_name) as TextView
    val buttonDelete: ImageButton = itemView!!.findViewById(R.id.ib_delete_hero) as ImageButton

    fun updateContent(hero: Hero) {
        charName.text = hero.name
        buttonDelete.setOnClickListener({
            run {
                itemListener.onDeleteItem(hero)
            }
        })
    }

    interface ItemListener {
        fun onDeleteItem(hero: Hero)
    }
}