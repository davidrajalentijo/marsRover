package com.draja.marsrover.ui.instructions

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.draja.marsrover.domain.MoveRoverUseCase
import com.draja.marsrover.domain.entity.CoordinatesModel
import com.draja.marsrover.domain.entity.RoverCommandsModel
import com.draja.ui.ViewState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel(
    private val moveRoverUseCase: MoveRoverUseCase
) : ViewModel() {

    var marsGridX = mutableStateOf("")
    var marsGridY = mutableStateOf("")
    var roverPositionX = mutableStateOf("")
    var roverPositionY = mutableStateOf("")
    var roverOrientation = mutableStateOf("N")
    var limitedTextInput = mutableStateOf("")


    private val _moveRover = MutableLiveData<ViewState<Boolean>>(ViewState.Idle)
    val moveRover: LiveData<ViewState<Boolean>> = _moveRover

    fun areFieldsValid(): Boolean {
        val conditions = listOf(
            marsGridX.value.isEmpty(),
            marsGridY.value.isEmpty(),
            roverPositionX.value.isEmpty(),
            roverPositionY.value.isEmpty(),
            limitedTextInput.value.isEmpty()
        )

        return !conditions.any { it }
    }

    fun sendRoverCommands() {
        viewModelScope.launch {
            _moveRover.value = ViewState.Loading
            moveRoverUseCase.invoke(
                RoverCommandsModel(
                    topRightCorner = CoordinatesModel(
                        x = marsGridX.value.toInt(),
                        y = marsGridY.value.toInt()
                    ),
                    roverPosition = CoordinatesModel(
                        x = roverPositionX.value.toInt(),
                        y = roverPositionY.value.toInt()
                    ),
                    roverDirection = roverOrientation.value,
                    movements = limitedTextInput.value
                )
            ).onSuccess {
                _moveRover.value = ViewState.Success(it)
            }.onFailure {
                _moveRover.value = ViewState.Error(it)
            }
        }
    }

    fun resetMoveRoverState() {
        _moveRover.value = ViewState.Idle
    }
}