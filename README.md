# Dagger-2-Android-App-essential

The most basic and correct setup for Dagger 2 with Android for dependency injection. This project can be said as a template to Dagger with an example for SharedPreferences.

## Overview
If you launch the project you will be seeing a place holder text view, edit text and a save button. This is to verfiy that our dependency injection is working and the shared preferences are correctly injected into the MainActivity.

Follow the below steps to add another activity:

#### Go to ActivityModule.kt, you should be looking at the following:
```
@Module
abstract class ActivityModule {

    @ContributesAndroidInjector()
    abstract fun contributeMainActivity(): MainActivity

}
```
In the above class, add an entry for the activity you want to inject depencies in similar to the MainActiivty.
Also, make the activity implement the injectable interface. This will avoid us conflict with other libraries such as Glide

```

class MainActivity : AppCompatActivity(), Injectable {
  ...
}
```

For Example injection, we have provided the AppModule with a method annotated with @Provide interface to show how to construct the SharedPreferences for us, as shown below:

```
@Provides
@Singleton
fun providesAppPrefs(context: Application): SharedPreferences {
     return context.getSharedPreferences(PrefConstants.KEY_APP_SHARED_PREFS, Context.MODE_PRIVATE)
}
```

Similarly you can add dependencies for Room Database, DAO, retrofit, okhttp, gson and much more.
