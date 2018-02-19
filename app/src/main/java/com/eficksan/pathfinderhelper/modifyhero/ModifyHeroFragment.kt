package com.eficksan.pathfinderhelper.modifyhero

import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.eficksan.pathfinderhelper.App
import com.eficksan.pathfinderhelper.ModifyHeroActivity
import com.eficksan.pathfinderhelper.R
import com.eficksan.pathfinderhelper.di.createhero.CreateHeroComponent
import com.eficksan.pathfinderhelper.di.createhero.CreateHeroModule
import com.eficksan.pathfinderhelper.di.createhero.DaggerCreateHeroComponent
import com.eficksan.pathfinderhelper.models.Hero
import kotlinx.android.synthetic.main.fragment_create_hero.*
import javax.inject.Inject


/**
 * Created by Aleksei
 * on 18.10.2017.
 */
class ModifyHeroFragment : Fragment(), ModifyHeroContract.View, View.OnClickListener {

    var injector: CreateHeroComponent? = null

    @Inject
    lateinit var presenter: ModifyHeroContract.Presenter

    companion object {
        const val KEY_HERO_ID = "KEY_HERO_ID"
        fun createHero(): ModifyHeroFragment  = ModifyHeroFragment()
        fun editHero(heroId: String): ModifyHeroFragment {
            val fragment = ModifyHeroFragment()
            val args = Bundle()
            args.putString(KEY_HERO_ID, heroId)
            fragment.arguments = args
            return fragment
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as ModifyHeroActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)

        if (injector == null) {
            injector = DaggerCreateHeroComponent.builder()
                    .appComponent(App.appComponent)
                    .createHeroModule(CreateHeroModule(this))
                    .build()
            injector!!.inject(this)
        }

        lifecycle.addObserver(presenter)

        arguments?.let {
            val heroId = arguments.getString(KEY_HERO_ID)
            if (!heroId.isNullOrEmpty()) {
                presenter.onEditHero(heroId)
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater!!.inflate(R.layout.fragment_create_hero, container, false)

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fab_commit.setOnClickListener(this)
        et_hero_name.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable?) {}

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(name: CharSequence?, start: Int, before: Int, count: Int) {
                presenter.onNameChanged(name)
            }
        })
    }

    override fun onClick(view: View?) {
        when (view!!.id) {
            R.id.fab_commit -> presenter.onSubmit()
        }
    }
    override fun isSubmitEnabled(isEnabled: Boolean) {
        if (isEnabled){
            fab_commit.visibility = View.VISIBLE
        } else {
            fab_commit.visibility = View.INVISIBLE
        }
    }

    override fun onHeroCreated(newHero: Hero) {
        Toast.makeText(activity,getString(R.string.create_hero_success_hero_created, newHero.name), Toast.LENGTH_LONG).show()
        activity.finish()
    }
    override fun onHeroUpdated(hero: Hero) {
        Toast.makeText(activity,getString(R.string.create_hero_success_hero_updated, hero.name), Toast.LENGTH_LONG).show()
        activity.finish()
    }

    override fun onHeroCreationError(errorCode: Int) {
        when (errorCode) {
            ModifyHeroContract.ERROR_NONE-> et_hero_name.error = null
            ModifyHeroContract.ERROR_EMPTY_NAME-> et_hero_name.error = getString(R.string.create_hero_error_empty_name)
            ModifyHeroContract.ERROR_NAME_EXIST-> et_hero_name.error = getString(R.string.create_hero_error_name_exists)
        }
    }
    override fun updateHero(hero: Hero) {
        et_hero_name.setText(hero.name)
    }
}