package com.draja.marsrover.domain

import com.draja.marsrover.data.repository.RoverRepository
import com.draja.marsrover.domain.entity.RoverPositionModel
import com.draja.marsrover.domain.entity.mapper.toModel

class GetRoverPositionUseCase(private val roverRepository: RoverRepository){

    suspend operator fun invoke(): Result<RoverPositionModel> =
         roverRepository.getRoverPosition().map { it.toModel() }
}