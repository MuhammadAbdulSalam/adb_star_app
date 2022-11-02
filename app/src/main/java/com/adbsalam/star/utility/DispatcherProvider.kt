package com.adbsalam.star.utility

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers


class CoroutineDispatcherProvider {
    val io: CoroutineDispatcher
        get() = Dispatchers.IO

    val ui: CoroutineDispatcher
        get() = Dispatchers.Main
}