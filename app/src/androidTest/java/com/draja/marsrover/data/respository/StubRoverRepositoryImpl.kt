package com.draja.marsrover.data.respository

import com.draja.marsrover.data.network.request.RoverCommandsRequest
import com.draja.marsrover.data.network.response.RoverPositionResponse
import com.draja.marsrover.data.repository.RoverRepository

class StubRoverRepositoryImpl : RoverRepository {

    override suspend fun getRoverPosition(): Result<RoverPositionResponse> =
        Result.success(RoverPositionResponse(1, 2, "N"))

    override suspend fun moveRover(roverCommandsRequest: RoverCommandsRequest): Result<Boolean> =
        Result.success(true)
}