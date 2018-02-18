package com.eficksan.pathfinderhelper.dao

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.eficksan.pathfinderhelper.dao.hero.HeroesDao
import com.eficksan.pathfinderhelper.dao.hero.SpellBookItemEntity
import com.eficksan.pathfinderhelper.dao.spell.BridgeSpellComponents
import com.eficksan.pathfinderhelper.dao.spell.SpellsLibraryDao
import com.eficksan.pathfinderhelper.dao.spellbook.SpellBookDao
import com.eficksan.pathfinderhelper.dao.spellbook.SpellBookEntity
import com.eficksan.pathfinderhelper.models.Hero
import com.eficksan.pathfinderhelper.models.Spell
import com.eficksan.pathfinderhelper.models.SpellComponent

/**
 * Created by Aleksei on 06.02.2018.
 */

@Database(entities = arrayOf(
        Hero::class,
        Spell::class,
        SpellBookEntity::class,
        SpellBookItemEntity::class,
        BridgeSpellComponents::class,
        SpellComponent::class),
        version = 2,
        exportSchema = false)
abstract class RootDatabase : RoomDatabase() {

    abstract fun heroesDao(): HeroesDao
    abstract fun spellBookDao(): SpellBookDao
    abstract fun spellsLibraryDao(): SpellsLibraryDao
}