package com.eficksan.pathfinderhelper.di.charlist

import com.eficksan.pathfinderhelper.charlist.HeroListFragment
import com.eficksan.pathfinderhelper.di.AppComponent
import com.eficksan.pathfinderhelper.di.FragmentScope
import dagger.Component

/**
 * Created by Aleksei
 * on 19.10.2017.
 */
@FragmentScope
@Component(
        dependencies = arrayOf(AppComponent::class),
        modules = arrayOf(CharListModule::class)
)
interface HeroListComponent {

    fun inject(fragment: HeroListFragment)
}