package com.draja.marsrover.data.repository

import com.draja.marsrover.data.datasource.cloud.RoverCloudDataSource
import com.draja.marsrover.data.network.request.RoverCommandsRequest
import com.draja.marsrover.data.network.response.RoverPositionResponse

class RoverRepositoryImpl(
    private val roverCloudDataSource: RoverCloudDataSource
) : RoverRepository {

    override suspend fun getRoverPosition(): Result<RoverPositionResponse> =
        roverCloudDataSource.getRoverPosition()

    override suspend fun moveRover(roverCommandsRequest: RoverCommandsRequest): Result<Boolean> =
        roverCloudDataSource.moveRover(roverCommandsRequest)

}