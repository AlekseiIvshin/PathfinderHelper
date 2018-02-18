package com.eficksan.pathfinderhelper.di.heroeslist

import com.eficksan.pathfinderhelper.di.AppComponent
import com.eficksan.pathfinderhelper.di.FragmentScope
import com.eficksan.pathfinderhelper.heroeslist.HeroListFragment
import dagger.Component

/**
 * Created by Aleksei
 * on 19.10.2017.
 */
@Component(
        dependencies = arrayOf(AppComponent::class),
        modules = arrayOf(HeroListModule::class)
)
@FragmentScope
interface HeroListComponent {

    fun inject(fragment: HeroListFragment)
}