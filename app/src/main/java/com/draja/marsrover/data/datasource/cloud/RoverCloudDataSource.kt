package com.draja.marsrover.data.datasource.cloud

import com.draja.marsrover.data.network.ApiConstants
import com.draja.marsrover.data.network.request.RoverCommandsRequest
import com.draja.marsrover.data.network.response.RoverPositionResponse
import com.draja.network.HttMethodRequest
import com.draja.network.NetworkService

class RoverCloudDataSource(
    private val networkService: NetworkService? = NetworkService.getInstance()
) {

    suspend fun getRoverPosition(): Result<RoverPositionResponse> =
        networkService?.createApi<RoverPositionResponse>(
            ApiConstants.GET_ROVER_POSITION,
            HttMethodRequest.GET
        )
            ?: Result.failure(Exception("Network Service not available"))

    suspend fun moveRover(roverCommandsRequest: RoverCommandsRequest): Result<Boolean> {
        val response =
            networkService?.createApi<Any>(
                ApiConstants.MOVE_ROVER,
                HttMethodRequest.POST,
                body = roverCommandsRequest,
            ) ?: return Result.failure(Exception("Network Service not available"))

        response.onSuccess {
            return Result.success(true)
        }.onFailure {
            return Result.failure(it)
        }

        return Result.failure(Exception("Unknown error"))
    }
}