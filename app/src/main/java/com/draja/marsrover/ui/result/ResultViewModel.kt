package com.draja.marsrover.ui.result

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.draja.marsrover.domain.GetRoverPositionUseCase
import com.draja.marsrover.domain.entity.RoverPositionModel
import com.draja.ui.ViewState
import kotlinx.coroutines.launch

class ResultViewModel(
    private val getRoverPositionUseCase: GetRoverPositionUseCase
) : ViewModel() {

    private val _roverPosition = MutableLiveData<ViewState<RoverPositionModel>>(ViewState.Idle)
    val roverPosition: LiveData<ViewState<RoverPositionModel>> = _roverPosition
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