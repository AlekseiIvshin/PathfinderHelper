package com.eficksan.pathfinderhelper

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.eficksan.pathfinderhelper.createhero.CreateHeroFragment
import kotlinx.android.synthetic.main.activity_create_hero.*

class CreateHeroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_hero)

        setSupportActionBar(toolbar)

        if(savedInstanceState==null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.content, CreateHeroFragment(), null)
                    .commit()
        }
    }
}