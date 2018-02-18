package com.eficksan.pathfinderhelper.models

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.eficksan.pathfinderhelper.dao.hero.HeroContract
import java.util.*

/**
 * Created by Aleksei on 04.02.2018.
 */
@Entity(tableName = HeroContract.TABLE_NAME)
data class Hero(
        @ColumnInfo(name = HeroContract.NAME)
        var name: String
) {
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = HeroContract._ID)
    var id: String = ""

    companion object {
        fun createNewHero(name: String): Hero {
            val hero = Hero(name)
            hero.id = UUID.randomUUID().toString()
            return hero
        }
    }
}