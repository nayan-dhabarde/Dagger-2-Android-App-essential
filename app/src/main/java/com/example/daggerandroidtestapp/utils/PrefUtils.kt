package com.example.daggerandroidtestapp.utils

import android.content.SharedPreferences

object PrefConstants {
    const val KEY_APP_SHARED_PREFS = "KEY_APP_SHARED_PREFS"
}

/**
 * Extension function for shared preferences
 */
fun SharedPreferences.putValues(func:(SharedPreferences.Editor)-> Unit){
    val editor: SharedPreferences.Editor = this.edit()
    func(editor)
    editor.apply()
}