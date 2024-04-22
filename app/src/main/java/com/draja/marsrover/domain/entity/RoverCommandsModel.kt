package com.draja.marsrover.domain.entity

data class RoverCommandsModel(
    val topRightCorner: CoordinatesModel = CoordinatesModel(),
    val roverPosition: CoordinatesModel = CoordinatesModel(),
    val roverDirection: String = Direction.N.name,
    val movements: String = ""
)

data class CoordinatesModel(
    val x: Int = 0,
    val y: Int = 0
)

enum class Direction {
    N, E, S, W
}