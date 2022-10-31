package com.adbsalam.star.moduleinjector

import com.adbsalam.star.api.RetrofitBuilder
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





}