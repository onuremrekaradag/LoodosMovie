package com.kefelon.loodosmovie.di.module

import com.kefelon.loodosmovie.di.scope.ActivityScoped
import com.kefelon.loodosmovie.di.scope.FragmentScoped
import com.kefelon.loodosmovie.ui.main.MainActivity
import com.kefelon.loodosmovie.ui.main.MainActivityModule
import com.kefelon.loodosmovie.ui.moviedetail.MovieDetailFragment
import com.kefelon.loodosmovie.ui.moviedetail.MovieDetailModule
import com.kefelon.loodosmovie.ui.moviesearch.SearchFragment
import com.kefelon.loodosmovie.ui.moviesearch.SearchFragmentModule
import com.kefelon.loodosmovie.ui.splash.SplashScreenActivityModule
import com.kefelon.loodosmovie.ui.splash.SplashScreenActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {
    @ActivityScoped
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun bindMainActivity(): MainActivity

    @ActivityScoped
    @ContributesAndroidInjector(modules = [SplashScreenActivityModule::class])
    abstract fun bindSplashScreenActivity(): SplashScreenActivity

    @FragmentScoped
    @ContributesAndroidInjector(modules = [SearchFragmentModule::class])
    abstract fun bindSearchFragment(): SearchFragment

    @FragmentScoped
    @ContributesAndroidInjector(modules = [MovieDetailModule::class])
    abstract fun bindMovieDetailFragment(): MovieDetailFragment
}