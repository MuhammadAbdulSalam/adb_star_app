package com.adbsalam.star.application

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject


interface AppInitializer {
    fun init(application: Application)
}

@HiltAndroidApp
class MainApplication : Application(){
    @Inject
    lateinit var initializer: AppInitializer

    override fun onCreate() {
        super.onCreate()
        initializer.init(this)
    }

}