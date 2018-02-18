package com.eficksan.pathfinderhelper.dao.spell

/**
 * Created by Aleksei on 03.02.2018.
 */
interface SpellLibraryContract {
    companion object {
        const val TABLE_NAME = "spells_library"

        const val _ID = "_id"
        const val NAME = "name"
        const val SCHOOL = "school"
        const val LEVEL = "level"
        const val CASTING_TIME = "casting_time"
        const val RANGE = "range"
        const val EFFECT = "effect"
        const val TARGET = "target"
        const val DURATION = "duration"
        const val SAVING_THROWS = "saving_throws"
        const val SPELL_RESISTANCE = "spell_resistance"

        const val COLUMN_ID = TABLE_NAME +"."+ _ID
        const val COLUMN_NAME = TABLE_NAME +"."+ NAME
        const val COLUMN_SCHOOL = TABLE_NAME +"."+ SCHOOL
        const val COLUMN_LEVEL = TABLE_NAME +"."+ LEVEL
        const val COLUMN_CASTING_TIME = TABLE_NAME +"."+ CASTING_TIME
        const val COLUMN_RANGE = TABLE_NAME +"."+ RANGE
        const val COLUMN_EFFECT = TABLE_NAME +"."+ EFFECT
        const val COLUMN_TARGET = TABLE_NAME +"."+ TARGET
        const val COLUMN_DURATION = TABLE_NAME +"."+ DURATION
        const val COLUMN_SAVING_THROWS = TABLE_NAME +"."+ SAVING_THROWS
        const val COLUMN_SPELL_RESISTANCE = TABLE_NAME +"."+ SPELL_RESISTANCE
    }
}