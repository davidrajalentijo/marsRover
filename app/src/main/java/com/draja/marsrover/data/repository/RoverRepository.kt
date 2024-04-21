package com.draja.marsrover.data.repository

import com.draja.marsrover.data.network.request.RoverCommandsRequest
import com.draja.marsrover.data.network.response.RoverPositionResponse

interface RoverRepository {

    suspend fun getRoverPosition(): Result<RoverPositionResponse>

    suspend fun moveRover(roverCommandsRequest: RoverCommandsRequest): Result<Boolean>
}