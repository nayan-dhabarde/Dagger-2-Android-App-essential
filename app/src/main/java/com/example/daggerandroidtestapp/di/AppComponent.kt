package com.example.daggerandroidtestapp.di

import android.app.Application
import com.example.daggerandroidtestapp.CustomApp
import com.example.daggerandroidtestapp.di.module.ActivityModule
import com.example.daggerandroidtestapp.di.module.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidInjectionModule::class,
    ActivityModule::class,
    AppModule::class
])
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: CustomApp)
}