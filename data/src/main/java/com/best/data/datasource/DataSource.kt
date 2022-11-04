package com.best.data.datasource

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

interface DataSource {

    val defaultDispatcher: CoroutineDispatcher get() = Dispatchers.IO
}