package com.kefelon.loodosmovie.ui.moviedetail

import com.kefelon.loodosmovie.base.BaseFragment
import com.kefelon.loodosmovie.di.module.ActivityModule
import com.kefelon.loodosmovie.di.scope.FragmentScoped
import dagger.Binds
import dagger.Module

@Module(includes = [ActivityModule::class])
abstract class MovieDetailModule {
    @FragmentScoped
    @Binds
    abstract fun bindBaseActivity(fragment: MovieDetailFragment): BaseFragment
}