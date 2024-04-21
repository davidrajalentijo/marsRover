package com.draja.marsrover.data.network.response

import kotlinx.serialization.Serializable

@Serializable
data class RoverPositionResponse(
    val x: Int = 0,
    val y: Int = 0,
    val direction: String = ""
)