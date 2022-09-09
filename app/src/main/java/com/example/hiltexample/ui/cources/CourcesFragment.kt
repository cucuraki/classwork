package com.example.hiltexample.ui.cources

import android.graphics.drawable.GradientDrawable
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hiltexample.data.responsestate.ResponseState
import com.example.hiltexample.databinding.FragmentCourcesBinding
import com.example.hiltexample.ui.basefragments.BaseFragment
import com.example.hiltexample.ui.cources.adapters.HorizontalAdapter
import com.example.hiltexample.ui.cources.adapters.SpaceItemDecoratorHorizontal
import com.example.hiltexample.ui.cources.adapters.SpacingItemDecorator
import com.example.hiltexample.ui.cources.adapters.VerticalAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CourcesFragment : BaseFragment<FragmentCourcesBinding>(FragmentCourcesBinding::inflate) {
    private val viewModel: CourcesViewModel by viewModels()
    private val verticalAdapter: VerticalAdapter by lazy {
        VerticalAdapter()
    }

    private val horizontalAdapter: HorizontalAdapter by lazy {
        HorizontalAdapter()
    }

    override fun init() {
        viewModel.getActiveCourses()
        viewModel.getNewCourses()
        bindVerticalRecycler()
        bindHorizontalRecycler()
    }

    override fun observe() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.coursesStateFlow.collect {
                    when (it) {
                        is ResponseState.Success -> {
                            verticalAdapter.submitList(it.model)
                        }
                        is ResponseState.Error -> {
                            if (it.message != "_") {
                                toast(it.message)
                            }
                        }
                    }
                }
            }
        }
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.newCoursesFlow.collect {
                    when (it) {
                        is ResponseState.Success -> {
                            horizontalAdapter.submitList(it.model)
                        }
                        is ResponseState.Error -> {
                            if (it.message != "_") {
                                toast(it.message)
                            }
                        }
                    }
                }
            }
        }
    }

    private fun bindVerticalRecycler(){
        with(binding) {
            courses.addItemDecoration(SpacingItemDecorator())
            courses.adapter = verticalAdapter
            courses.layoutManager = LinearLayoutManager(context)
        }
    }

    private fun bindHorizontalRecycler(){
        with(binding) {
            newCourses.addItemDecoration(SpaceItemDecoratorHorizontal())
            newCourses.adapter = horizontalAdapter
            newCourses.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }
    }
}