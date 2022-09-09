package com.example.hiltexample.data.apis

import com.example.hiltexample.data.models.CourcesModel
import retrofit2.Response
import retrofit2.http.GET

interface CourcesApi{
    @GET("4167a598-b68c-420f-b6e1-fef68b89a10d")
    suspend fun getData(): Response<CourcesModel>
}