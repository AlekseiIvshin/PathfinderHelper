package com.eficksan.pathfinderhelper.dao.skills

/**
 * Created by Aleksei on 03.02.2018.
 */
interface SkillsContract {
    companion object {
        const val TABLE_NAME = "skills"

        const val _ID = "_id"
        const val NAME = "name"

        const val COLUMN_ID = TABLE_NAME+"." + _ID
        const val COLUMN_NAME = TABLE_NAME+"." + NAME
    }
}