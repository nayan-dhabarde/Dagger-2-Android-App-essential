package com.example.daggerandroidtestapp.di

import android.app.Activity
import android.app.Application
import android.os.Bundle
import com.example.daggerandroidtestapp.di.DaggerAppComponent
import com.example.daggerandroidtestapp.CustomApp
import dagger.android.AndroidInjection

object AppInjector {
    fun init(app: CustomApp) {
        DaggerAppComponent
            .builder()
            .application(app)
            .build()
            .inject(app)


        app.registerActivityLifecycleCallbacks(object: Application.ActivityLifecycleCallbacks {
            override fun onActivityPaused(activity: Activity?) {
            }

            override fun onActivityResumed(activity: Activity?) {
            }

            override fun onActivityStarted(activity: Activity?) {
            }

            override fun onActivityDestroyed(activity: Activity?) {
            }

            override fun onActivitySaveInstanceState(activity: Activity?, outState: Bundle?) {
            }

            override fun onActivityStopped(activity: Activity?) {
            }
            override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
                handleActivity(activity)
            }

        })
    }

    private fun handleActivity(activity: Activity) {
        if(activity is Injectable) {
            AndroidInjection.inject(activity)
        }

    }
}