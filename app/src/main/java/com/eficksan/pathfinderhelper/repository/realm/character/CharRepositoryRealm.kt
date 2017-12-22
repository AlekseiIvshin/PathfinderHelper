package com.eficksan.pathfinderhelper.repository.realm.character

import com.eficksan.pathfinderhelper.models.Hero
import com.eficksan.pathfinderhelper.repository.character.CharRepository
import com.eficksan.pathfinderhelper.repository.character.CharSpec
import com.eficksan.pathfinderhelper.repository.realm.RealmRepository

/**
 * Created by Aleksei on 18.10.2017.
 */
class CharRepositoryRealm: CharRepository, RealmRepository<Hero,CharSpec>()