package com.example.daggerandroidtestapp.di.module

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.example.daggerandroidtestapp.utils.PrefConstants
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module()
class AppModule {

    @Provides
    @Singleton
    fun providesAppPrefs(context: Application): SharedPreferences {
        return context.getSharedPreferences(PrefConstants.KEY_APP_SHARED_PREFS, Context.MODE_PRIVATE)
    }
}