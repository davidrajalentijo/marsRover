package com.draja.marsrover.ui.result

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.draja.marsrover.domain.GetRoverPositionUseCase
import com.draja.marsrover.domain.MoveRoverUseCase
import com.draja.marsrover.domain.entity.CoordinatesModel
import com.draja.marsrover.domain.entity.RoverCommandsModel
import com.draja.marsrover.domain.entity.RoverPositionModel
import com.draja.ui.ViewState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ResultViewModel(
    private val getRoverPositionUseCase: GetRoverPositionUseCase
) : ViewModel() {

    private val _roverPosition = MutableStateFlow<ViewState<RoverPositionModel>>(ViewState.Idle)
    val roverPosition = _roverPosition.asStateFlow()

    init {
        getRoverPosition()
    }

    private fun getRoverPosition() {
        viewModelScope.launch {
            _roverPosition.value = ViewState.Loading
            getRoverPositionUseCase.invoke().onSuccess {
                _roverPosition.value = ViewState.Success(it)
            }.onFailure {
                _roverPosition.value = ViewState.Error(it)
            }
        }
    }
}