package com.eficksan.pathfinderhelper.createhero

import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.eficksan.pathfinderhelper.App
import com.eficksan.pathfinderhelper.CreateHeroActivity
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
class CreateHeroFragment : Fragment(), CreateHeroContract.View, View.OnClickListener {

    var injector: CreateHeroComponent? = null

    @Inject
    lateinit var presenter: CreateHeroContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (injector == null) {
            injector = DaggerCreateHeroComponent.builder()
                    .appComponent(App.appComponent)
                    .createHeroModule(CreateHeroModule(this))
                    .build()
            injector!!.inject(this)
        }

        lifecycle.addObserver(presenter)

        (activity as CreateHeroActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
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

    override fun onHeroCreationError(errorCode: Int) {
        when (errorCode) {
            CreateHeroContract.ERROR_NONE-> et_hero_name.error = null
            CreateHeroContract.ERROR_EMPTY_NAME-> et_hero_name.error = getString(R.string.create_hero_error_empty_name)
            CreateHeroContract.ERROR_NAME_EXIST-> et_hero_name.error = getString(R.string.create_hero_error_name_exists)
        }
    }
}