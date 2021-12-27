package com.example.composeapp.network

import com.example.composeapp.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ServiceCreator {
    private const val BASE_URL = "https://api-dev.mwellph.com"
    private val logger =
        HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
    private val httpClient = OkHttpClient.Builder().apply {
        addInterceptor(logger)
//        addInterceptor(HeaderInterceptor())
//        if (BuildConfig.DEBUG_LOG) {
//            addInterceptor(logger)
//        }
//        addInterceptor(TokenIntercept())
        readTimeout(30, TimeUnit.SECONDS)
        connectTimeout(30, TimeUnit.SECONDS)
    }

    private val builder = Retrofit.Builder()
        .baseUrl(getUrl())
        .client(httpClient.build())
        .addConverterFactory(GsonConverterFactory.create())

    private val retrofit = builder.build()

    fun <T> create(serviceClass: Class<T>): T = retrofit.create(serviceClass)


    private fun getUrl(): String {
        return BASE_URL
    }
}