package com.eficksan.pathfinderhelper.dao.hero

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.PrimaryKey
import com.eficksan.pathfinderhelper.dao.spell.SpellLibraryContract
import com.eficksan.pathfinderhelper.dao.spellbook.SpellBookContract
import com.eficksan.pathfinderhelper.models.Spell
import com.eficksan.pathfinderhelper.models.SpellComponent

/**
 * Created by Aleksei on 03.02.2018.
 */
@Entity(tableName = SpellBookItemContract.TABLE_NAME,
        foreignKeys = arrayOf(
                ForeignKey(entity = Spell::class,
                        parentColumns = arrayOf(SpellLibraryContract._ID),
                        childColumns = arrayOf(SpellBookItemContract.SPELL_ID),
                        onDelete = ForeignKey.CASCADE
                ),
                ForeignKey(entity = SpellComponent::class,
                        parentColumns = arrayOf(SpellBookContract._ID),
                        childColumns = arrayOf(SpellBookItemContract.BOOK_ID),
                        onDelete = ForeignKey.CASCADE
                )))
data class SpellBookItemEntity(
        @ColumnInfo(name = SpellBookItemContract.SPELL_ID)
        var spellId: String,
        @ColumnInfo(name = SpellBookItemContract.BOOK_ID)
        var heroId: String,
        @ColumnInfo(name = SpellBookItemContract.IS_PREPARED)
        var isPrepared: Boolean,
        @ColumnInfo(name = SpellBookItemContract.PREPARED_COUNT)
        var preparedCount: Int
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = SpellBookItemContract._ID)
    var id: Long = 0
}