package com.example.hiltexample.ui.cources

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hiltexample.data.models.CourcesModel
import com.example.hiltexample.data.repositorys.ActiveCourcesRepository
import com.example.hiltexample.data.repositorys.NewCourcesRepository
import com.example.hiltexample.data.responsestate.ResponseState
import com.example.hiltexample.ui.cources.models.ActiveCourcesModel
import com.example.hiltexample.ui.cources.models.NewCursesModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CourcesViewModel @Inject constructor(
    private val activeCourcesRepository: ActiveCourcesRepository,
    private val newCoursesRepository: NewCourcesRepository
) : ViewModel() {
    private val _coursesStateFlow = MutableStateFlow<ResponseState<List<ActiveCourcesModel>>>(ResponseState.Error("_"))
    val coursesStateFlow = _coursesStateFlow.asStateFlow()

    private val _newCoursesFlow = MutableStateFlow<ResponseState<List<NewCursesModel>>>(ResponseState.Error("_"))
    val newCoursesFlow = _newCoursesFlow.asStateFlow()
    fun getActiveCourses(){
        viewModelScope.launch {
            val data = activeCourcesRepository.getData()
            _coursesStateFlow.value = data
        }
    }

    fun getNewCourses(){
        viewModelScope.launch {
            val data = newCoursesRepository.getData()
            _newCoursesFlow.value = data
        }
    }
}