package com.eficksan.pathfinderhelper.dao.spell

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import com.eficksan.pathfinderhelper.models.SpellComponent

/**
 * Created by Aleksei on 03.02.2018.
 */
@Dao
interface ComponentsDao {

    @Query("SELECT * FROM " + ComponentContract.TABLE_NAME)
    fun loadAllComponents(): LiveData<List<SpellComponent>>

    @Query("SELECT DISTINCT "+ ComponentContract.TABLE_NAME+".* " +
            "FROM "+ ComponentContract.TABLE_NAME+", "+BridgeSpellComponentContract.TABLE_NAME+" " +
            "WHERE "+BridgeSpellComponentContract.COLUMN_SPELL_COMPONENT_ID+" LIKE "+ ComponentContract.COLUMN_ID+" " +
            "AND "+BridgeSpellComponentContract.COLUMN_SPELL_ID+" LIKE :spellId")
    fun loadSpeelComponents(spellId: String): List<SpellComponent>
}