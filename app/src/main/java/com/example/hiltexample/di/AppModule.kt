package com.example.hiltexample.di

import com.example.hiltexample.data.apis.CourcesApi
import com.example.hiltexample.data.repositorys.ActiveCourcesRepository
import com.example.hiltexample.data.repositorys.ActiveCourcesRepositoryImpl
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun getActiveCourcesRepository(api: CourcesApi): ActiveCourcesRepository = ActiveCourcesRepositoryImpl(api)

    @Provides
    @Singleton
    fun getApi(retrofit: Retrofit): CourcesApi {
        return retrofit.create(CourcesApi::class.java)
    }

    @Provides
    @Singleton
    fun getRetrofit(): Retrofit {
        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
        return Retrofit.Builder().baseUrl("https://run.mocky.io/v3/").addConverterFactory(
            MoshiConverterFactory.create(moshi)
        ).build()
    }

}