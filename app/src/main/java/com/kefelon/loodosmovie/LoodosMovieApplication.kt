package com.kefelon.loodosmovie

import com.google.firebase.FirebaseApp
import com.kefelon.loodosmovie.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.internal.DaggerCollections
import dagger.android.DaggerApplication


class LoodosMovieApplication : DaggerApplication() {

    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(applicationContext)
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().application(this).build()
    }

}
