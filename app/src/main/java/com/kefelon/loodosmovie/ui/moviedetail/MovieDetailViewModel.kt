package com.kefelon.loodosmovie.ui.moviedetail

import androidx.lifecycle.MutableLiveData
import com.kefelon.loodosmovie.base.BaseViewModel
import javax.inject.Inject

class MovieDetailViewModel @Inject constructor() : BaseViewModel() {

    var movieTitle = MutableLiveData<String>()
    var movieYear = MutableLiveData<String>()


    override fun start() = Unit

    override fun stop() {
        disposable.dispose()
    }


}