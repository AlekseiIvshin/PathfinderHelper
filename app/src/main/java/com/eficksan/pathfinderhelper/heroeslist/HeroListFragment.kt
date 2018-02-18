package com.eficksan.pathfinderhelper.heroeslist

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.eficksan.pathfinderhelper.App
import com.eficksan.pathfinderhelper.CreateHeroActivity
import com.eficksan.pathfinderhelper.R
import com.eficksan.pathfinderhelper.di.heroeslist.DaggerHeroListComponent
import com.eficksan.pathfinderhelper.di.heroeslist.HeroListComponent
import com.eficksan.pathfinderhelper.di.heroeslist.HeroListModule
import com.eficksan.pathfinderhelper.models.Hero
import kotlinx.android.synthetic.main.fragment_heroes_list.*
import javax.inject.Inject

/**
 * Created by Aleksei
 * on 18.10.2017.
 */
class HeroListFragment : Fragment(), HeroListContract.View, View.OnClickListener, HeroListItemViewHolder.ItemListener {

    var injector: HeroListComponent? = null

    @Inject
    lateinit var presenter: HeroListContract.Presenter

    var heroListAdapter: HeroListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (injector == null) {
            injector = DaggerHeroListComponent.builder()
                    .appComponent(App.appComponent)
                    .heroListModule(HeroListModule(this))
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

        fab_item_add.setOnClickListener(this)
        fab_item_delete.setOnClickListener(this)
        fab_item_edit.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view!!.id) {
            R.id.fab_item_add -> presenter.onCreateNewHero()
        }
    }

    override fun updateHeroes(heroes: List<Hero>?) {
        heroListAdapter?.updateItems(heroes)
    }

    override fun showCreateHeroScreen() {
        startActivity(Intent(activity, CreateHeroActivity::class.java))
    }

    override fun onDeleteItem(hero: Hero) {
        presenter.onDeleteHero(hero.name)
    }
}