package com.example.hiltexample.ui.cources

import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hiltexample.data.responsestate.ResponseState
import com.example.hiltexample.databinding.FragmentCourcesBinding
import com.example.hiltexample.ui.basefragments.BaseFragment
import com.example.hiltexample.ui.cources.adapters.VerticalAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CourcesFragment : BaseFragment<FragmentCourcesBinding>(FragmentCourcesBinding::inflate) {
    private val viewModel: CourcesViewModel by viewModels()
    private val verticalAdapter: VerticalAdapter by lazy {
        VerticalAdapter()
    }

    override fun init() {
        viewModel.getActiveCourses()
        with(binding) {
            courses.adapter = verticalAdapter
            courses.layoutManager = LinearLayoutManager(context)
        }
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
    }
}