package com.zodiacsign.app.ext

import com.zodiacsign.app.data.model.Result
import com.zodiacsign.app.di.GsonProvider
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response

suspend fun <T> responseWrapper(service: suspend () -> Response<T>): Flow<Result<T>> = flow {
    try {
        emit(Result.Loading())
        val response = service()
        if (response.isSuccessful) {
            response.body()?.let {
                emit(Result.Success(it))
            } ?: kotlin.run {
                emit(Result.Error("Response body is null"))
            }
        } else {
            val errorString = response.errorBody()?.string()
            try {
                val responseError = GsonProvider.get().fromJson(errorString, String::class.java)
                if (!responseError.isNullOrEmpty()) {
                    emit(Result.Error(responseError))
                } else {
                    emit(Result.Error("Error response is null or empty"))
                }
            } catch (e: Exception) {
                emit(Result.Error(e.message.toString()))
            }
        }
    } catch (e: Exception) {
        emit(Result.Error(e.message.toString()))
    }
}