package com.eficksan.pathfinderhelper.dao.spellbook

/**
 * Created by Aleksei on 03.02.2018.
 */
interface SpellBookContract {
    companion object {
        const val TABLE_NAME = "spell_book"

        const val _ID = "_id"
        const val HERO_ID = "hero_id"
        const val SPELLS_LEVEL_COUNT = "spells_level_count" // String in format [5,2,1,0...]

        const val COLUMN_ID = TABLE_NAME+"." + _ID
        const val COLUMN_HERO_ID = TABLE_NAME+"." + HERO_ID
        const val COLUMN_SPELLS_LEVEL_COUNT = TABLE_NAME+"." + SPELLS_LEVEL_COUNT
    }
}