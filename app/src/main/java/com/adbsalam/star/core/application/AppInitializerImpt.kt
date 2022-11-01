package com.adbsalam.star.core.application

import android.app.Application
import com.adbsalam.star.application.AppInitializer

class AppInitializerImpl(private vararg val initializers: AppInitializer) : AppInitializer {
    override fun init(application: Application) {
        initializers.forEach {
            it.init(application)
        }
    }
}