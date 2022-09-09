package com.example.hiltexample.data.repositorys

import com.example.hiltexample.data.apis.CourcesApi
import com.example.hiltexample.data.responsestate.ResponseState
import com.example.hiltexample.ui.cources.models.NewCursesModel

class NewCourcesRepositoryImpl(private val api: CourcesApi): NewCourcesRepository
{
    override suspend fun getData(): ResponseState<List<NewCursesModel>> {
        return try {
            val response = api.getData()
            if (response.isSuccessful) {
                ResponseState.Success(response.body()!!.toNewCoursesList())
            } else {
                ResponseState.Error(response.errorBody()!!.string())
            }
        } catch (e: Exception) {
            ResponseState.Error(e.toString())
        }
    }
}