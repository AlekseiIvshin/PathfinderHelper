package com.eficksan.pathfinderhelper.dao.spell

/**
 * Created by Aleksei on 03.02.2018.
 */
interface BridgeSpellComponentContract {
    companion object {
        const val TABLE_NAME = "bridge_" + SpellLibraryContract.TABLE_NAME + "_" + ComponentContract.TABLE_NAME

        const val _ID = "_id"
        const val SPELL_ID = "spell_id"
        const val SPELL_COMPONENT_ID = "spell_component_id"

        const val COLUMN_ID = TABLE_NAME+"." + _ID
        const val COLUMN_SPELL_ID = TABLE_NAME+"." + SPELL_ID
        const val COLUMN_SPELL_COMPONENT_ID = TABLE_NAME+"." + SPELL_COMPONENT_ID
    }
}