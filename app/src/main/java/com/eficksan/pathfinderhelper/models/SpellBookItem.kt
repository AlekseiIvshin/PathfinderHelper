package com.eficksan.pathfinderhelper.models

import android.arch.persistence.room.ColumnInfo
import com.eficksan.pathfinderhelper.dao.spellbook.SpellBookCompoundItemContract

/**
 * Created by Aleksei on 03.02.2018.
 */
data class SpellBookItem(
        @ColumnInfo(name = SpellBookCompoundItemContract._ID)
        var itemId: String,
        @ColumnInfo(name = SpellBookCompoundItemContract.SPELL_ID)
        var spellId: String,
        @ColumnInfo(name = SpellBookCompoundItemContract.BOOK_ID)
        var bookId: String,
        @ColumnInfo(name = SpellBookCompoundItemContract.NAME)
        var name: String,
        @ColumnInfo(name = SpellBookCompoundItemContract.SCHOOL)
        var school: String,
        @ColumnInfo(name = SpellBookCompoundItemContract.LEVEL)
        var level: Int,
        @ColumnInfo(name = SpellBookCompoundItemContract.CASTING_TIME)
        var castingTime: String,
        @ColumnInfo(name = SpellBookCompoundItemContract.RANGE)
        var range: String,
        @ColumnInfo(name = SpellBookCompoundItemContract.EFFECT)
        var effect: String,
        @ColumnInfo(name = SpellBookCompoundItemContract.TARGET)
        var target: String,
        @ColumnInfo(name = SpellBookCompoundItemContract.DURATION)
        var duration: String,
        @ColumnInfo(name = SpellBookCompoundItemContract.SAVING_THROWS)
        var savingThrows: String,
        @ColumnInfo(name = SpellBookCompoundItemContract.SAVING_RESISTANCE)
        var savingResistance: Boolean,
        @ColumnInfo(name = SpellBookCompoundItemContract.IS_PREPARED)
        var isPrepared: Boolean,
        @ColumnInfo(name = SpellBookCompoundItemContract.PREPARED_COUNT)
        var preparedCount: Int
)