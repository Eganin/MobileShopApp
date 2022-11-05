package com.best.data.repository

import com.best.data.util.DefaultDispatchers
import com.best.domain.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.withContext
import okio.IOException
import retrofit2.HttpException

internal suspend fun <T> FlowCollector<Resource<T>>.bodyForDataLoading(dispatchers: DefaultDispatchers,blockResponse: suspend () -> T){
    emit(Resource.Loading(isLoading = true))
    val response = try {
        withContext(dispatchers.io()){
            blockResponse()
        }
    } catch (e: IOException) {
        e.printStackTrace()
        emit(Resource.Error(message = "Couldn't load data"))
        null
    } catch (e: HttpException) {
        e.printStackTrace()
        emit(Resource.Error(message = "Couldn't load data"))
        null
    } catch (e: Exception) {
        e.printStackTrace()
        emit(Resource.Error(message = "Unknown error.Turn on Gps and restart the application"))
        null
    }

    response?.let {
        emit(Resource.Loading(isLoading = false))
        emit(Resource.Success(data = it))
    }
}