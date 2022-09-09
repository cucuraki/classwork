package com.example.hiltexample.data.repositorys

import com.example.hiltexample.data.responsestate.ResponseState
import com.example.hiltexample.ui.cources.models.ActiveCourcesModel



interface ActiveCourcesRepository {
    suspend fun getData(): ResponseState<List<ActiveCourcesModel>>
}