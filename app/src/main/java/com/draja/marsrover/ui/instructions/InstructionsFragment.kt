package com.draja.marsrover.ui.instructions

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.draja.marsrover.R
import com.draja.marsrover.databinding.FragmentInstructionsBinding
import com.draja.ui.ViewState
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class InstructionsFragment : Fragment() {

    private val viewModel: MainViewModel by viewModel()
    private lateinit var binding: FragmentInstructionsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentInstructionsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        sendInstructionsObserver()
        viewModel.resetMoveRoverState()
    }

    private fun initView() {
        binding.directionsInput.setOnCheckedChangeListener { _, checkedId ->
            val radioButton = when (checkedId) {
                R.id.north_radio_button -> binding.northRadioButton
                R.id.south_radio_button -> binding.southRadioButton
                R.id.west_radio_button -> binding.westRadioButton
                R.id.east_radio_button -> binding.eastRadioButton
                else -> null
            }
            viewModel.roverOrientation.value = radioButton?.text.toString()
        }
        binding.sendButton.setOnClickListener {
            saveButtonAction()
        }
    }

    private fun setValues() {
        binding.apply {
            viewModel.marsGridX.value = marsX.text.toString()
            viewModel.marsGridY.value = marsY.text.toString()
            viewModel.roverPositionX.value = roverX.text.toString()
            viewModel.roverPositionY.value = roverY.text.toString()
            viewModel.limitedTextInput.value = roverCommandsInput.text.toString()
        }
    }

    private fun saveButtonAction() {
        setValues()
        if (viewModel.areFieldsValid()) {
            viewModel.sendRoverCommands()
        } else {
            Toast.makeText(
                context,
                R.string.error_empty,
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun sendInstructionsObserver() {
        viewModel.moveRover.observe(viewLifecycleOwner) { result ->
            when (result) {
                is ViewState.Loading -> {
                    showLoading(true)
                }

                is ViewState.Success -> {
                    showLoading(false)
                    findNavController().navigate(
                        R.id.action_instructionsFragment_to_resultFragment
                    )
                }

                is ViewState.Error -> {
                    showLoading(false)
                    Toast.makeText(
                        context,
                        R.string.error_message,
                        Toast.LENGTH_SHORT
                    ).show()
                }

                else -> {
                    showLoading(false)
                }
            }
        }
    }

    private fun showLoading(isLoading: Boolean) {
        binding.loadingSpinner.visibility = if (isLoading) View.VISIBLE else View.GONE
    }
}