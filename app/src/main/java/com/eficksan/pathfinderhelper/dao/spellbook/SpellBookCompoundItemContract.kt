package com.eficksan.pathfinderhelper.dao.spellbook

/**
 * Created by Aleksei on 03.02.2018.
 */
interface SpellBookCompoundItemContract {
    companion object {
        const val _ID = "compound_item_id"
        const val SPELL_ID = "compound_spellId"
        const val BOOK_ID = "compound_bookId"
        const val NAME = "compound_name"
        const val SCHOOL = "compound_school"
        const val LEVEL = "compound_level"
        const val CASTING_TIME = "compound_castingTime"
        const val RANGE = "compound_range"
        const val EFFECT = "compound_effect"
        const val TARGET = "compound_target"
        const val DURATION = "compound_duration"
        const val SAVING_THROWS = "compound_savingThrows"
        const val SAVING_RESISTANCE = "compound_savingResistance"
        const val PREPARED_COUNT = "compound_preparedCount"
        const val IS_PREPARED = "compound_isPrepared"
    }
}