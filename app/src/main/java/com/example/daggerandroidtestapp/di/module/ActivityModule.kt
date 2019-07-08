package com.example.daggerandroidtestapp.di.module

import com.example.daggerandroidtestapp.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Abstract class to specify the activities in which Dependencies need to be injected
 */
@Module
abstract class ActivityModule {

    @ContributesAndroidInjector()
    abstract fun contributeMainActivity(): MainActivity

}