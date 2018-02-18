package com.eficksan.pathfinderhelper

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.eficksan.pathfinderhelper.heroeslist.HeroListFragment
import kotlinx.android.synthetic.main.activity_create_hero.*

class HeroSelectorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hero_selector)

        setSupportActionBar(toolbar)

        supportFragmentManager.beginTransaction()
                .replace(R.id.content, HeroListFragment(), null)
                .commit()
    }

}