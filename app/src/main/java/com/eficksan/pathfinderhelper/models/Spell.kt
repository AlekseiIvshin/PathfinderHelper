package com.eficksan.pathfinderhelper.models

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.eficksan.pathfinderhelper.dao.spell.SpellLibraryContract

/**
 * Created by Aleksei on 03.02.2018.
 */
@Entity(tableName = SpellLibraryContract.TABLE_NAME)
data class Spell(
        @ColumnInfo(name = SpellLibraryContract.NAME)
        var name: String,
        @ColumnInfo(name = SpellLibraryContract.SCHOOL)
        var school: String,
        @ColumnInfo(name = SpellLibraryContract.LEVEL)
        var level: Int,
        @ColumnInfo(name = SpellLibraryContract.CASTING_TIME)
        var castingTime: String,
        @ColumnInfo(name = SpellLibraryContract.RANGE)
        var range: String,
        @ColumnInfo(name = SpellLibraryContract.EFFECT)
        var effect: String,
        @ColumnInfo(name = SpellLibraryContract.TARGET)
        var target: String,
        @ColumnInfo(name = SpellLibraryContract.DURATION)
        var duration: String,
        @ColumnInfo(name = SpellLibraryContract.SAVING_THROWS)
        var savingThrows: String,
        @ColumnInfo(name = SpellLibraryContract.SPELL_RESISTANCE)
        var savingResistance: Boolean
) {
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = SpellLibraryContract._ID)
    var id: String = ""
}