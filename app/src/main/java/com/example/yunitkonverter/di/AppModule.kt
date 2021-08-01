package com.example.yunitkonverter.di

import android.content.Context
import com.example.yunitkonverter.BaseApplication
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideApplication(@ApplicationContext app: Context): BaseApplication{
        return app as BaseApplication
    }

    @Singleton
    @Provides
    fun provideMotivation():String{
        return "Imagine I am doing dependency injection right now!..WOW!!"
    }




}