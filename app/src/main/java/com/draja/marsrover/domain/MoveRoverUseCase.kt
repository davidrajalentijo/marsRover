package com.draja.marsrover.domain

import com.draja.marsrover.data.repository.RoverRepository
import com.draja.marsrover.domain.entity.RoverCommandsModel
import com.draja.marsrover.domain.entity.mapper.toRequest

class MoveRoverUseCase(private val roverRepository: RoverRepository) {

    suspend operator fun invoke(roverCommandsModel: RoverCommandsModel): Result<Boolean> =
        roverRepository.moveRover(roverCommandsModel.toRequest())
}