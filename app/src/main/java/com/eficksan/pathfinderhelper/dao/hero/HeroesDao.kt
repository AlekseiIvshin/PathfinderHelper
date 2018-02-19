package com.eficksan.pathfinderhelper.dao.hero

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import com.eficksan.pathfinderhelper.models.Hero

/**
 * Created by Aleksei on 03.02.2018.
 */
@Dao
interface HeroesDao {

    @Query("SELECT * FROM " + HeroContract.TABLE_NAME)
    fun loadAllHeroes(): LiveData<List<Hero>>

    @Query("SELECT * FROM " + HeroContract.TABLE_NAME +" WHERE "+HeroContract.COLUMN_NAME+" LIKE :name")
    fun searchByName(name: String): LiveData<List<Hero>>

    @Query("SELECT COUNT("+HeroContract.COLUMN_NAME+") FROM " + HeroContract.TABLE_NAME +" WHERE "+HeroContract.COLUMN_NAME+" LIKE :name")
    fun checkExistenceByName(name: String): Int

    @Query("SELECT * FROM " + HeroContract.TABLE_NAME +" WHERE "+HeroContract.COLUMN_ID+" LIKE :id")
    fun searchById(id: String): LiveData<Hero>

    @Insert
    fun insertHero(hero: Hero)

    @Update
    fun updateHero(hero: Hero): Int

    @Delete
    fun deleteHero(hero: Hero)

}