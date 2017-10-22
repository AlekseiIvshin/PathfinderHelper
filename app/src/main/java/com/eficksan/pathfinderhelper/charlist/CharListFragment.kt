package com.eficksan.pathfinderhelper.charlist

import android.arch.lifecycle.LifecycleFragment
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.eficksan.pathfinderhelper.App
import com.eficksan.pathfinderhelper.R
import com.eficksan.pathfinderhelper.di.charlist.CharListComponent
import com.eficksan.pathfinderhelper.di.charlist.CharListModule
import com.eficksan.pathfinderhelper.di.charlist.DaggerCharListComponent
import com.eficksan.pathfinderhelper.models.Character
import kotlinx.android.synthetic.main.fragment_char_list.*
import javax.inject.Inject

/**
 * Created by Aleksei
 * on 18.10.2017.
 */
class CharListFragment :LifecycleFragment(), CharListContract.View, View.OnClickListener, CharListItemViewHolder.ItemListener {

    var injector: CharListComponent? = null

    @Inject
    lateinit var presenter: CharListContract.Presenter

    var charListAdapter: CharListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (injector == null) {
            injector = DaggerCharListComponent.builder()
                    .appComponent(App.appComponent)
                    .charListModule(CharListModule(this))
                    .build()
            injector!!.inject(this)
        }

        charListAdapter = CharListAdapter(this)

        lifecycle.addObserver(presenter)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater!!.inflate(R.layout.fragment_char_list, container, false)

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        characters.layoutManager = LinearLayoutManager(context)
        characters.adapter = charListAdapter

        addNewCharacter.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view!!.id) {
            R.id.addNewCharacter -> presenter.onCreateNewChar()
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

    override fun updateChars(characters: List<Character>?) {
        charListAdapter?.updateItems(characters)
    }

    override fun onDeleteItem(character: Character) {
        presenter.onDeleteChar(character.name)
    }
}