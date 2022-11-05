package com.best.data.util

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

interface DefaultDispatchers {
    fun io(): CoroutineDispatcher

    fun default(): CoroutineDispatcher

    fun main(): CoroutineDispatcher

    class Base : DefaultDispatchers {
        override fun io(): CoroutineDispatcher {
            return Dispatchers.IO
        }

        override fun default(): CoroutineDispatcher {
            return Dispatchers.Default
        }

        override fun main(): CoroutineDispatcher {
            return Dispatchers.Main
        }
    }
}