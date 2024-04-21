package com.draja.marsrover.data.network.request

import com.draja.marsrover.domain.entity.Direction
import kotlinx.serialization.Serializable

@Serializable
data class RoverCommandsRequest(
    val topRightCorner: CoordinatesRequest = CoordinatesRequest(),
    val roverPosition: CoordinatesRequest = CoordinatesRequest(),
    val roverDirection: String = Direction.N.name,
    val movements: String = ""
)

@Serializable
data class CoordinatesRequest(
    val x: Int = 0,
    val y: Int = 0
)