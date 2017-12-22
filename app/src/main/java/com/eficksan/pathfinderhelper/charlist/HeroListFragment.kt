package com.eficksan.pathfinderhelper.charlist

import android.arch.lifecycle.LifecycleFragment
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.eficksan.pathfinderhelper.App
import com.eficksan.pathfinderhelper.R
import com.eficksan.pathfinderhelper.di.charlist.HeroListComponent
import com.eficksan.pathfinderhelper.di.charlist.CharListModule
import com.eficksan.pathfinderhelper.di.charlist.DaggerHeroListComponent
import com.eficksan.pathfinderhelper.models.Hero
import kotlinx.android.synthetic.main.fragment_heroes_list.*
import javax.inject.Inject

/**
 * Created by Aleksei
 * on 18.10.2017.
 */
class HeroListFragment :LifecycleFragment(), HeroListContract.View, View.OnClickListener, HeroListItemViewHolder.ItemListener {

    var injector: HeroListComponent? = null

    @Inject
    lateinit var presenter: HeroListContract.Presenter

    var heroListAdapter: HeroListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (injector == null) {
            injector = DaggerHeroListComponent.builder()
                    .appComponent(App.appComponent)
                    .charListModule(CharListModule(this))
                    .build()
            injector!!.inject(this)
        }

        heroListAdapter = HeroListAdapter(this)

        lifecycle.addObserver(presenter)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater!!.inflate(R.layout.fragment_heroes_list, container, false)

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        heroes.layoutManager = LinearLayoutManager(context)
        heroes.adapter = heroListAdapter

        addNewHero.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view!!.id) {
            R.id.addNewHero -> presenter.onCreateNewChar()
        }
    }

    override fun showCreateCharacter() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//        with(activity.supportFragmentManager.beginTransaction()) {
//            add(R.id.fragments_container, AddTaskFragment(), AddTaskFragment::class.java.simpleName)
//            addToBackStack(null)
//            commit()
//        }
    }

    override fun updateHeroes(heroes: List<Hero>?) {
        heroListAdapter?.updateItems(heroes)
    }

    override fun onDeleteItem(hero: Hero) {
        presenter.onDeleteChar(hero.name)
    }
}