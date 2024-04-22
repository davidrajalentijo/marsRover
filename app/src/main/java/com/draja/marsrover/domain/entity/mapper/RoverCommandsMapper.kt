package com.draja.marsrover.domain.entity.mapper

import com.draja.marsrover.data.network.request.CoordinatesRequest
import com.draja.marsrover.data.network.request.RoverCommandsRequest
import com.draja.marsrover.domain.entity.CoordinatesModel
import com.draja.marsrover.domain.entity.RoverCommandsModel

fun RoverCommandsModel.toRequest(): RoverCommandsRequest =
    RoverCommandsRequest(
        topRightCorner = topRightCorner.toRequest(),
        roverPosition = roverPosition.toRequest(),
        roverDirection = roverDirection,
        movements = movements
    )

fun CoordinatesModel.toRequest(): CoordinatesRequest =
    CoordinatesRequest(
        x = x,
        y = y
    )

