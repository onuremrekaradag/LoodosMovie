package com.kefelon.loodosmovie.di.module

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.kefelon.loodosmovie.base.BaseActivity
import com.kefelon.loodosmovie.di.scope.ActivityContext
import com.kefelon.loodosmovie.di.scope.ActivityScoped
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class ActivityModule {
    @ActivityScoped
    @Binds
    abstract fun bindAppCompatActivity(activity: BaseActivity): AppCompatActivity

    @ActivityScoped
    @Binds
    abstract fun bindActivity(activity: AppCompatActivity): Activity

    @ActivityContext
    @ActivityScoped
    @Binds
    abstract fun bindActivityContext(activity: Activity): Context

    companion object {
        @JvmStatic
        @ActivityScoped
        @Provides
        fun provideFragmentManager(
            activity: AppCompatActivity
        ): FragmentManager = activity.supportFragmentManager

    }
}