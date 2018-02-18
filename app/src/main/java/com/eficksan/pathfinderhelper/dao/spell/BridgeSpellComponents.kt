package com.eficksan.pathfinderhelper.dao.spell

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.PrimaryKey
import com.eficksan.pathfinderhelper.models.Spell
import com.eficksan.pathfinderhelper.models.SpellComponent

/**
 * Created by Aleksei on 03.02.2018.
 */
@Entity(tableName = BridgeSpellComponentContract.TABLE_NAME,
        foreignKeys = arrayOf(
                ForeignKey(entity = Spell::class,
                        parentColumns = arrayOf(SpellLibraryContract._ID),
                        childColumns = arrayOf(BridgeSpellComponentContract.SPELL_ID),
                        onDelete = ForeignKey.CASCADE
                ),
                ForeignKey(entity = SpellComponent::class,
                        parentColumns = arrayOf(ComponentContract._ID),
                        childColumns = arrayOf(BridgeSpellComponentContract.SPELL_COMPONENT_ID),
                        onDelete = ForeignKey.CASCADE
                )))
data class BridgeSpellComponents(
        @ColumnInfo(name = BridgeSpellComponentContract.SPELL_ID)
        var spellId: String,
        @ColumnInfo(name = BridgeSpellComponentContract.SPELL_COMPONENT_ID)
        var spellComponentId: String
) {
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = BridgeSpellComponentContract._ID)
    var id: String = ""
}