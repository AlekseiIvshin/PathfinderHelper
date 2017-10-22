package com.eficksan.pathfinderhelper.charlist

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.Observer
import android.arch.lifecycle.OnLifecycleEvent
import com.eficksan.pathfinderhelper.models.Character
import com.eficksan.pathfinderhelper.mvp.BasePresenter
import com.eficksan.pathfinderhelper.repository.character.CharRepository
import com.eficksan.pathfinderhelper.repository.character.CharSpecFactory
import com.eficksan.pathfinderhelper.viewmodel.CharListViewModel

/**
 * Created by Aleksei
 * on 18.10.2017.
 */
class CharListPresenter(
        val view: CharListContract.View,
        val viewModel: CharListViewModel,
        val charRepository: CharRepository,
        val specFactory: CharSpecFactory): BasePresenter, CharListContract.Presenter{

    var charListObserver: Observer<List<Character>> = Observer { it -> view.updateChars(it) }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    override fun onActive() {
        viewModel.setSpec(specFactory.findAll())
        viewModel.charsList.observe(view, charListObserver)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    override fun onInActive() {
        viewModel.charsList.removeObserver { charListObserver }
    }

    override fun onCreateNewChar() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCharSelected() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onDeleteChar(name: String) {
        charRepository.removeItem(specFactory.findCharByName(name))
    }

}