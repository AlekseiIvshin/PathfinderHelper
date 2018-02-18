package com.eficksan.pathfinderhelper.dao.spell

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import com.eficksan.pathfinderhelper.models.Spell

/**
 * Created by Aleksei on 03.02.2018.
 */
@Dao
interface SpellsLibraryDao {

    @Query("SELECT * FROM " + SpellLibraryContract.TABLE_NAME)
    fun loadAllSpells(): LiveData<List<Spell>>

}