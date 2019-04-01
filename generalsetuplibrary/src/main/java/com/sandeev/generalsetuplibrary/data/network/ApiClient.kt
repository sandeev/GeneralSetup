package com.sandeev.generalsetuplibrary.data.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApiClient(private val baseUrl: String) {

    private var connectTimeout = 10
    private var writeTimeout = 60
    private var readTimeout = 10

    constructor(baseUrl: String, connectTimeout: Int?, writeTimeout: Int?, readTimeout: Int?) : this(baseUrl) {
        connectTimeout?.let { this.connectTimeout = it }
        writeTimeout?.let { this.writeTimeout = it }
        readTimeout?.let { this.readTimeout = it }
    }

    private fun request(accessToken: String?): Retrofit {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.let {
            it.level = HttpLoggingInterceptor.Level.HEADERS
            it.level = HttpLoggingInterceptor.Level.BODY
        }

        val client = OkHttpClient.Builder()
            .connectTimeout(connectTimeout.toLong(), TimeUnit.SECONDS)
            .writeTimeout(writeTimeout.toLong(), TimeUnit.SECONDS)
            .readTimeout(readTimeout.toLong(), TimeUnit.SECONDS)
            .addInterceptor { chain ->
                val request = chain.request()
                val newRequest: Request

                newRequest = request.newBuilder()
                    .addHeader("Authorization", "Bearer $accessToken")
                    .build()

                chain.proceed(newRequest)
            }
            .addInterceptor(loggingInterceptor)
            .build()

        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .client(client)
            .build()
    }

    fun <T> createService(accessToken: String?, service: Class<T>): T {
        return request(accessToken).create(service)
    }
}