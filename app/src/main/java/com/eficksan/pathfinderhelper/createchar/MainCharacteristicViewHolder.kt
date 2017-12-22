package com.eficksan.pathfinderhelper.createchar

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import com.eficksan.pathfinderhelper.R

/**
 * Created by Aleksei
 * on 19.10.2017.
 */
class MainCharacteristicViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
    val charName: TextView = itemView!!.findViewById(R.id.tv_hero_name) as TextView
    val charValue: TextView = itemView!!.findViewById(R.id.tv_char_value) as TextView
    val charMod: TextView = itemView!!.findViewById(R.id.tv_char_mod) as TextView
    val charRandom: ImageButton = itemView!!.findViewById(R.id.ib_char_random) as ImageButton
    val charDecrease: ImageButton = itemView!!.findViewById(R.id.ib_char_decrease) as ImageButton
    val charIncrease: ImageButton = itemView!!.findViewById(R.id.ib_char_increase) as ImageButton

    fun updateContent(charListener: CharListener, name: String, value: Int, modificator: Int) {
        charName.text = name
        charValue.text = value.toString()
        charMod.text = modificator.toString()
        charRandom.setOnClickListener {
            run {
                charListener.onRandomClicked()
            }
        }
        charDecrease.setOnClickListener {
            run {
                charListener.onValueDecreased()
            }
        }
        charIncrease.setOnClickListener {
            run {
                charListener.onValueIncreased()
            }
        }
    }

    interface CharListener {
        fun onValueDecreased()
        fun onValueIncreased()
        fun onRandomClicked()
    }
}