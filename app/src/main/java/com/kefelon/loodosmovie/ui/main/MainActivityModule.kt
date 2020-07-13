package com.kefelon.loodosmovie.ui.main

import com.kefelon.loodosmovie.base.BaseActivity
import com.kefelon.loodosmovie.di.module.ActivityModule
import com.kefelon.loodosmovie.di.scope.ActivityScoped
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module(includes = [ActivityModule::class])
abstract class MainActivityModule {
    @ActivityScoped
    @Binds
    abstract fun bindBaseActivity(activity: MainActivity): BaseActivity
}