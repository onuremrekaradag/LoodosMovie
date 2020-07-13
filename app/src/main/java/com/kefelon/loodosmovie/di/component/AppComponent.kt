package com.kefelon.loodosmovie.di.component

import android.app.Application
import com.kefelon.loodosmovie.LoodosMovieApplication
import com.kefelon.loodosmovie.di.module.*
import com.kefelon.loodosmovie.di.scope.AppScoped
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@AppScoped
@Component(
    modules = [
        AppModule::class,
        ActivityBindingModule::class,
        ViewModelModule::class,
        NetworkModule::class,
        AndroidSupportInjectionModule::class
    ]
)
interface AppComponent : AndroidInjector<LoodosMovieApplication> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent


    }
}
