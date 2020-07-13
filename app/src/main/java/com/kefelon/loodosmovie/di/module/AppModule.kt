package com.kefelon.loodosmovie.di.module

import android.content.Context
import com.kefelon.loodosmovie.LoodosMovieApplication
import com.kefelon.loodosmovie.data.remote.services.OMDBApiService
import com.kefelon.loodosmovie.di.scope.AppScoped
import com.kefelon.loodosmovie.di.scope.ApplicationContext
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class AppModule {

    @ApplicationContext
    @AppScoped
    @Provides
    internal fun provideContext(application: LoodosMovieApplication): Context = application

}