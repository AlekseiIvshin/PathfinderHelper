package com.eficksan.pathfinderhelper.charlist

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import com.eficksan.pathfinderhelper.R
import com.eficksan.pathfinderhelper.models.Character

/**
 * Created by Aleksei
 * on 19.10.2017.
 */
class CharListItemViewHolder(itemView: View?, private val itemListener: ItemListener) : RecyclerView.ViewHolder(itemView) {
    val charName: TextView = itemView!!.findViewById(R.id.tv_char_name) as TextView
    val buttonDelete: ImageButton = itemView!!.findViewById(R.id.ib_delete_char) as ImageButton

    fun updateContent(character: Character) {
        charName.text = character.name
        buttonDelete.setOnClickListener({
            run {
                itemListener.onDeleteItem(character)
            }
        })
    }

    interface ItemListener {
        fun onDeleteItem(character: Character)
    }
}