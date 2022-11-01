package com.adbsalam.star.moduleinjector

import com.adbsalam.star.api.RetrofitBuilder
import com.adbsalam.star.application.AppInitializer
import com.adbsalam.star.application.MainApplication
import com.adbsalam.star.core.application.AppInitializerImpl
import com.adbsalam.star.utility.CoroutineDispatcherProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class ModuleInjector {

    /**
     * Retrofit Api Injection
     */
    @Singleton
    @Provides
    fun provideRetrofitService(): RetrofitBuilder {
        return RetrofitBuilder.create()
    }

    /**
     * Retrofit Api Injection
     */
    @Singleton
    @Provides
    fun provideCoroutineDispatcher(): CoroutineDispatcherProvider {
        return CoroutineDispatcherProvider()
    }


    @Provides
    @Singleton
    fun provideApplication(): MainApplication {
        return MainApplication()
    }

    @Provides
    @Singleton
    fun provideAppInitializer(
    ): AppInitializer {
        return AppInitializerImpl()
    }

}