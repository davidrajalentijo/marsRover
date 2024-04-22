package com.draja.marsrover.domain.entity.mapper

import com.draja.marsrover.data.network.response.RoverPositionResponse
import com.draja.marsrover.domain.entity.RoverPositionModel

fun RoverPositionResponse.toModel(): RoverPositionModel =
    RoverPositionModel(
        x = x,
        y = y,
        direction = direction
    )