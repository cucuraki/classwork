package com.example.hiltexample.data.repositorys

import com.example.hiltexample.data.responsestate.ResponseState
import com.example.hiltexample.ui.cources.models.NewCursesModel

interface NewCourcesRepository {

    suspend fun getData(): ResponseState<List<NewCursesModel>>
}