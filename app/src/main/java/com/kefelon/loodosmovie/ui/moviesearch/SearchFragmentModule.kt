package com.kefelon.loodosmovie.ui.moviesearch

import com.kefelon.loodosmovie.base.BaseFragment
import com.kefelon.loodosmovie.di.module.ActivityModule
import com.kefelon.loodosmovie.di.scope.FragmentScoped
import dagger.Binds
import dagger.Module

@Module(includes = [ActivityModule::class])
abstract class SearchFragmentModule {
    @FragmentScoped
    @Binds
    abstract fun bindBaseActivity(fragment: SearchFragment): BaseFragment
}