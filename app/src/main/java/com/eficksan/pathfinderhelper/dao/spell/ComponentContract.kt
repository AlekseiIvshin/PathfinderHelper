package com.eficksan.pathfinderhelper.dao.spell

/**
 * Created by Aleksei on 03.02.2018.
 */
interface ComponentContract {
    companion object {
        const val TABLE_NAME = "spells_components"

        const val _ID = "_id"
        const val TYPE = "type"
        const val ITEM_ID = "item_id"

        const val COLUMN_ID = TABLE_NAME+"." + _ID
        const val COLUMN_TYPE = TABLE_NAME+"." + TYPE
        const val COLUMN_ITEM_ID = TABLE_NAME+"." + ITEM_ID
    }
}