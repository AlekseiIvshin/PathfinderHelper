package com.eficksan.pathfinderhelper.dao.hero

/**
 * Created by Aleksei on 03.02.2018.
 */
interface SpellBookItemContract {
    companion object {
        const val TABLE_NAME = "spell_book_items"

        const val _ID = "_id"
        const val SPELL_ID = "spell_id"
        const val BOOK_ID = "book_id"
        const val IS_PREPARED = "is_prepared"
        const val PREPARED_COUNT = "prepared_count"

        const val COLUMN_ID = TABLE_NAME +"."+ _ID
        const val COLUMN_SPELL_ID = TABLE_NAME +"."+ SPELL_ID
        const val COLUMN_BOOK_ID = TABLE_NAME +"."+ BOOK_ID
        const val COLUMN_PREPARED_COUNT = TABLE_NAME +"."+ PREPARED_COUNT
        const val COLUMN_IS_PREPARED= TABLE_NAME +"."+ IS_PREPARED
    }
}