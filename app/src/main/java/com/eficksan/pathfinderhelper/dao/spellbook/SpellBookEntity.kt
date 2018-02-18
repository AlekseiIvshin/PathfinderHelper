package com.eficksan.pathfinderhelper.dao.spellbook

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.PrimaryKey
import com.eficksan.pathfinderhelper.dao.hero.HeroContract
import com.eficksan.pathfinderhelper.models.SpellComponent

/**
 * Created by Aleksei on 03.02.2018.
 */
@Entity(tableName = SpellBookContract.TABLE_NAME,
        foreignKeys = arrayOf(
                ForeignKey(entity = SpellComponent::class,
                        parentColumns = arrayOf(HeroContract._ID),
                        childColumns = arrayOf(SpellBookContract.HERO_ID),
                        onDelete = ForeignKey.CASCADE
                )))
data class SpellBookEntity(
        @ColumnInfo(name = SpellBookContract.HERO_ID)
        var heroId: String,
        @ColumnInfo(name = SpellBookContract.SPELLS_LEVEL_COUNT)
        var spellsLevelCount: String
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = SpellBookContract._ID)
    var id: Long = 0
}