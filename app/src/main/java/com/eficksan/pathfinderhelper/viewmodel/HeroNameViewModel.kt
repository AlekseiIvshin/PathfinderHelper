package com.eficksan.pathfinderhelper.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

/**
 * Created by Aleksei on 18.10.2017.
 */
class HeroNameViewModel : ViewModel() {

    var heroName: MutableLiveData<String> = MutableLiveData()

}