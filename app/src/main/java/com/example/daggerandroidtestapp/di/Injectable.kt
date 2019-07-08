package com.example.daggerandroidtestapp.di

/**
 * This should be added to all activities and fragments, in order to avoid injecting dependencies in other classes
 * like Glide
 * If you don't will lead in unexpected behavior
 */
interface Injectable {
}