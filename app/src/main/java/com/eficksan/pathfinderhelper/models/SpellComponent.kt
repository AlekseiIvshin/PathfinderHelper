package com.eficksan.pathfinderhelper.models

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.eficksan.pathfinderhelper.dao.spell.ComponentContract

/**
 * Created by Aleksei on 03.02.2018.
 */
@Entity(tableName = ComponentContract.TABLE_NAME)
data class SpellComponent(
        @ColumnInfo(name = ComponentContract.TYPE)
        var type: String,
        @ColumnInfo(name = ComponentContract.ITEM_ID)
        var itemId: String
) {
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name= ComponentContract._ID)
    var id: String = ""
}