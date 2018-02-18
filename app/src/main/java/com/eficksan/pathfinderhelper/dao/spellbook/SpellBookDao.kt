package com.eficksan.pathfinderhelper.dao.spellbook

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import com.eficksan.pathfinderhelper.dao.hero.SpellBookItemContract
import com.eficksan.pathfinderhelper.dao.spell.SpellLibraryContract
import com.eficksan.pathfinderhelper.models.Spell
import com.eficksan.pathfinderhelper.models.SpellBookItem

/**
 * Created by Aleksei on 03.02.2018.
 */
@Dao
interface SpellBookDao {

    @Query("SELECT * FROM " + SpellLibraryContract.TABLE_NAME)
    fun loadAllSpells(): LiveData<List<Spell>>

    @Query("SELECT DISTINCT " +
            SpellBookItemContract.COLUMN_ID + " AS " + SpellBookCompoundItemContract._ID + "," +
            SpellBookItemContract.COLUMN_SPELL_ID + " AS " + SpellBookCompoundItemContract.SPELL_ID + "," +
            SpellBookItemContract.COLUMN_BOOK_ID + " AS " + SpellBookCompoundItemContract.BOOK_ID + "," +
            SpellBookItemContract.COLUMN_PREPARED_COUNT + " AS " + SpellBookCompoundItemContract.PREPARED_COUNT + "," +
            SpellBookItemContract.COLUMN_IS_PREPARED + " AS " + SpellBookCompoundItemContract.IS_PREPARED + "," +
            SpellLibraryContract.COLUMN_NAME + " AS " + SpellBookCompoundItemContract.NAME + "," +
            SpellLibraryContract.COLUMN_SCHOOL + " AS " + SpellBookCompoundItemContract.SCHOOL + "," +
            SpellLibraryContract.COLUMN_LEVEL + " AS " + SpellBookCompoundItemContract.LEVEL + "," +
            SpellLibraryContract.COLUMN_CASTING_TIME + " AS " + SpellBookCompoundItemContract.CASTING_TIME + "," +
            SpellLibraryContract.COLUMN_RANGE + " AS " + SpellBookCompoundItemContract.RANGE + "," +
            SpellLibraryContract.COLUMN_EFFECT + " AS " + SpellBookCompoundItemContract.EFFECT + "," +
            SpellLibraryContract.COLUMN_TARGET + " AS " + SpellBookCompoundItemContract.TARGET + "," +
            SpellLibraryContract.COLUMN_DURATION + " AS " + SpellBookCompoundItemContract.DURATION + "," +
            SpellLibraryContract.COLUMN_SAVING_THROWS + " AS " + SpellBookCompoundItemContract.SAVING_THROWS + "," +
            SpellLibraryContract.COLUMN_SPELL_RESISTANCE + " AS " + SpellBookCompoundItemContract.SAVING_RESISTANCE + " " +
            "FROM " + SpellBookContract.TABLE_NAME + "," + SpellBookItemContract.TABLE_NAME + "," + SpellLibraryContract.TABLE_NAME + " " +
            "WHERE " + SpellLibraryContract.COLUMN_ID + " LIKE " + SpellBookCompoundItemContract.SPELL_ID + " " +
            "AND " + SpellBookItemContract.COLUMN_BOOK_ID + " LIKE " + SpellBookContract.COLUMN_ID + " " +
            "AND " + SpellBookContract.COLUMN_HERO_ID + " LIKE :heroId ")
    fun loadHeroSpells(heroId: String): LiveData<List<SpellBookItem>>

    @Query("SELECT DISTINCT " + SpellBookContract.COLUMN_SPELLS_LEVEL_COUNT+ " " +
            "FROM " + SpellBookContract.TABLE_NAME + " " +
            "WHERE "+SpellBookContract.COLUMN_ID +" LIKE :bookId")
    fun getSpellLevelCount(bookId: String): String

}