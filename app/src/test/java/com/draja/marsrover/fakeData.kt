package com.draja.marsrover

import com.draja.marsrover.data.network.request.CoordinatesRequest
import com.draja.marsrover.data.network.request.RoverCommandsRequest
import com.draja.marsrover.domain.entity.CoordinatesModel
import com.draja.marsrover.domain.entity.RoverCommandsModel

val roverCommandsModel = RoverCommandsModel(
    topRightCorner = CoordinatesModel(5,5),
    roverPosition = CoordinatesModel(1,2),
    "N",
    "LMLMLMLMM"
)

val roverCommandsRequest = RoverCommandsRequest(
    topRightCorner = CoordinatesRequest(5,5),
    roverPosition = CoordinatesRequest(1,2),
    "N",
    "LMLMLMLMM"
)