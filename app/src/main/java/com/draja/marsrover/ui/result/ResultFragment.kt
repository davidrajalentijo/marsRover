package com.draja.marsrover.ui.result

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.draja.marsrover.R
import com.draja.marsrover.databinding.FragmentInstructionsBinding
import com.draja.marsrover.databinding.FragmentResultBinding
import com.draja.marsrover.domain.entity.RoverPositionModel
import com.draja.marsrover.ui.instructions.MainViewModel
import com.draja.ui.ViewState
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class ResultFragment : Fragment() {

    private val viewModel: ResultViewModel by viewModel()
    private lateinit var binding: FragmentResultBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentResultBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolbar()
        roverPositionObserver()
    }

    private fun initToolbar() {
        binding.toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun roverPositionObserver() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.roverPosition.collect { state ->
                when (state) {
                    is ViewState.Loading -> {
                        showLoading(true)
                    }

                    is ViewState.Success -> {
                        showLoading(false)
                        setResultValues(state.data)
                    }

                    is ViewState.Error -> {
                        Toast.makeText(
                            context,
                            R.string.error_message,
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    ViewState.Idle -> {
                        showLoading(false)
                    }
                }
            }
        }
    }

    private fun setResultValues(roverPositionModel: RoverPositionModel) {
        binding.apply {
            resultOrientationValue.text = roverPositionModel.direction
            resultCoordinateXValue.text = roverPositionModel.x.toString()
            resultCoordinateYValue.text = roverPositionModel.y.toString()
        }
    }

    private fun showLoading(isLoading: Boolean) {
        binding.loading.visibility = if (isLoading) View.VISIBLE else View.GONE
    }
}