package com.kefelon.loodosmovie.ui.splash

import com.kefelon.loodosmovie.base.BaseActivity
import com.kefelon.loodosmovie.di.module.ActivityModule
import com.kefelon.loodosmovie.di.scope.ActivityScoped
import dagger.Binds
import dagger.Module

@Module(includes = [ActivityModule::class])
abstract class SplashScreenActivityModule {
    @ActivityScoped
    @Binds
    abstract fun bindBaseActivity(activity: SplashScreenActivity): BaseActivity
}