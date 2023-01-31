package com.example.prakashalay.network

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ServiceBuilder {
    private const val URL = "https://prakashalay.loophole.site/api/"
    //Create a Custom Interceptor to apply Headers application wide
    private val logger = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    private val headerInterceptor = Interceptor { chain ->
        var request = chain.request()
        request = request.newBuilder()
            .addHeader("forPrakashalay", "True")
            .addHeader("id",RequestHeaders.userId)
            .addHeader(RequestHeaders.parameter,"True")
//                .addHeader("x-device-type", Build.DEVICE)
//                .addHeader("Accept-Language", Locale.getDefault().language)
            .build()
        chain.proceed(request)
    }
    //Create OkHttp Client
    private val okHttp = OkHttpClient.Builder()
        .callTimeout(10,TimeUnit.SECONDS)
        .addInterceptor(headerInterceptor)
        .addInterceptor(logger)
    //Create Retrofit Builder
    private val builder = Retrofit.Builder().baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttp.build())
    //Create Retrofit Instance
    private val retrofit = builder.build()
    fun <T> buildService(serviceType: Class<T>): T {
        return retrofit.create(serviceType)
    }
}