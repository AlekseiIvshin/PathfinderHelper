package com.eficksan.pathfinderhelper.di.createhero

import com.eficksan.pathfinderhelper.createhero.CreateHeroFragment
import com.eficksan.pathfinderhelper.di.AppComponent
import com.eficksan.pathfinderhelper.di.FragmentScope
import dagger.Component

/**
 * Created by Aleksei
 * on 19.10.2017.
 */
@Component(
        dependencies = arrayOf(AppComponent::class),
        modules = arrayOf(CreateHeroModule::class)
)
@FragmentScope
interface CreateHeroComponent {

    fun inject(fragment: CreateHeroFragment)
}