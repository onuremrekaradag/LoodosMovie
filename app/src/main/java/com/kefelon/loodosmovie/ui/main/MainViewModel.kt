package com.kefelon.loodosmovie.ui.main

import androidx.lifecycle.MutableLiveData
import com.kefelon.loodosmovie.base.BaseViewModel
import com.kefelon.loodosmovie.data.remote.services.OMDBApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainViewModel @Inject constructor() : BaseViewModel() {

    @Inject
    lateinit var omdbApiService: OMDBApiService

    override fun start() = Unit

    override fun stop() {
        disposable.dispose()
    }
}