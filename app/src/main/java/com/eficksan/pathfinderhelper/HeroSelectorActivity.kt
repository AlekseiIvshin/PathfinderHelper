package com.eficksan.pathfinderhelper

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import com.eficksan.pathfinderhelper.charlist.HeroListFragment

class HeroSelectorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hero_selector)

        supportFragmentManager.beginTransaction()
                .replace(R.id.content, HeroListFragment(), null)
                .commit()
    }

}