package com.kefelon.loodosmovie.base

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel : ViewModel() {

    var disposable = CompositeDisposable()

    abstract fun start()

    abstract fun stop()

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}