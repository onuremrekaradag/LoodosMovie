package com.kefelon.loodosmovie.di.module

import android.app.Application
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.kefelon.loodosmovie.BuildConfig
import com.kefelon.loodosmovie.data.remote.services.OMDBApiService
import com.kefelon.loodosmovie.di.scope.AppScoped
import dagger.Module
import dagger.Provides
import dagger.Reusable
import io.reactivex.schedulers.Schedulers
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
object NetworkModule {

//    @Provides
//    @Reusable
//    @JvmStatic
//    fun provideGSON(): GsonConverterFactory {
//        return GsonConverterFactory.create()
//    }

    @Provides
    @Reusable
    @JvmStatic
    fun provideOKHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(1000, TimeUnit.SECONDS)
            .connectTimeout(1000, TimeUnit.SECONDS)
            .build()

    }

    @Provides
    @Reusable
    @JvmStatic
    internal fun provideRetrofitInterface(): Retrofit =
        Retrofit.Builder()
            .baseUrl(BuildConfig.API_URL)
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(HttpLoggingInterceptor()
                        .apply {
                            level = if (BuildConfig.DEBUG)
                                HttpLoggingInterceptor.Level.BODY
                            else
                                HttpLoggingInterceptor.Level.NONE
                        })
                    .readTimeout(1000, TimeUnit.SECONDS)
                    .writeTimeout(1000, TimeUnit.SECONDS)
                    .build()
            )
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .build()

    @Provides
    @Reusable
    @JvmStatic
    internal fun provideOmdbApi(retrofit: Retrofit): OMDBApiService {
        return retrofit.create(OMDBApiService::class.java)
    }
}