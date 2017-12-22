package com.eficksan.pathfinderhelper.createchar

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.eficksan.pathfinderhelper.R
import com.eficksan.pathfinderhelper.models.Hero

/**
 * Created by Aleksei
 * on 19.10.2017.
 */
class MainCharacteristicAdapter(hero: Hero) : RecyclerView.Adapter<MainCharacteristicViewHolder>() {

    override fun getItemCount(): Int = 6

    override fun onBindViewHolder(holderMain: MainCharacteristicViewHolder?, position: Int) {
//        when(position){
//            0->holderMain?.updateContent(heroes.se)
//        }

    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MainCharacteristicViewHolder =
            MainCharacteristicViewHolder(LayoutInflater.from(parent!!.context).inflate(R.layout.item_hero, parent, false))

}