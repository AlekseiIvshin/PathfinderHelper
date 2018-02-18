package com.eficksan.pathfinderhelper.createhero

import android.arch.lifecycle.MutableLiveData
import com.eficksan.pathfinderhelper.viewmodel.UseCaseViewModel

/**
 * Created by Aleksei on 18.02.2018.
 */
class CreateHeroViewModel(useCase: AddNewHeroUseCase) : UseCaseViewModel<String, Unit>(useCase) {

    var heroName: MutableLiveData<String> = MutableLiveData()
}