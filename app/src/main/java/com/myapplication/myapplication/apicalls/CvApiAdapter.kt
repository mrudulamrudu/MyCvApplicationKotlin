package com.myapplication.myapplication.apicalls

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class CvApiAdapter {

    companion object {

        private val BASE_API_URL = "https://gist.githubusercontent.com/"

        private var cvApiService: CvApiService? = null
        private var okHttpClient: OkHttpClient? = null

        @Synchronized
        fun getApiService(): CvApiService {
            if (cvApiService == null) {
                cvApiService = refreshCvApiService()
            }
            return cvApiService as CvApiService
        }

        private fun refreshCvApiService(): CvApiService {
            val okHttpClient = getHttpClient()
            val restAdapter = Retrofit.Builder()
                .baseUrl(BASE_API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()

            return restAdapter.create(CvApiService::class.java)
        }

        fun getHttpClient(): OkHttpClient {
            if (okHttpClient != null) return okHttpClient as OkHttpClient
            val builder = OkHttpClient().newBuilder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)

            val interceptor = HttpLoggingInterceptor()
            interceptor.apply { interceptor.level = HttpLoggingInterceptor.Level.BODY }

            builder.addInterceptor(interceptor)

            okHttpClient = builder.build()
            return okHttpClient as OkHttpClient
        }

    }
}