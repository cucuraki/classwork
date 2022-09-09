package com.example.hiltexample.data.repositorys

import com.example.hiltexample.data.apis.CourcesApi
import com.example.hiltexample.data.responsestate.ResponseState
import com.example.hiltexample.ui.cources.models.ActiveCourcesModel
import javax.inject.Inject

class ActiveCourcesRepositoryImpl @Inject constructor(
    private val api: CourcesApi
) : ActiveCourcesRepository {
    override suspend fun getData(): ResponseState<List<ActiveCourcesModel>>
    {
        return try {
            val response = api.getData()
            if (response.isSuccessful) {
                ResponseState.Success(response.body()!!.toActiveCourcesList())
            } else {
                ResponseState.Error(response.errorBody()!!.string())
            }
        } catch (e: Exception) {
            ResponseState.Error(e.toString())
        }
    }
}