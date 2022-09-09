package com.example.hiltexample.ui.cources

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hiltexample.data.repositorys.ActiveCourcesRepository
import com.example.hiltexample.data.responsestate.ResponseState
import com.example.hiltexample.ui.cources.models.ActiveCourcesModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CourcesViewModel @Inject constructor(
    private val activeCourcesRepository: ActiveCourcesRepository
) : ViewModel() {
    private val _coursesStateFlow = MutableStateFlow<ResponseState<List<ActiveCourcesModel>>>(ResponseState.Error("_"))
    val coursesStateFlow = _coursesStateFlow.asStateFlow()

    fun getActiveCourses(){
        viewModelScope.launch {
            val data = activeCourcesRepository.getData()
            _coursesStateFlow.value = data
        }
    }
}