package com.eficksan.pathfinderhelper

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.NavUtils
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.eficksan.pathfinderhelper.modifyhero.ModifyHeroFragment
import kotlinx.android.synthetic.main.activity_create_hero.*

class ModifyHeroActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_HERO_ID = "EXTRA_HERO_ID"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_hero)

        setSupportActionBar(toolbar)

        if (savedInstanceState == null) {
            val heroId = intent.getStringExtra(EXTRA_HERO_ID)
            val fragment: Fragment? = if (heroId.isNullOrEmpty()) {
                ModifyHeroFragment.createHero()
            } else {
                ModifyHeroFragment.editHero(heroId)
            }
            supportFragmentManager.beginTransaction()
                    .replace(R.id.content, fragment, null)
                    .commit()
        }
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                NavUtils.navigateUpFromSameTask(this)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}