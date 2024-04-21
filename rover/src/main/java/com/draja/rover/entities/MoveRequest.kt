package com.draja.rover.entities

data class MoveRequest(
    val topRightCorner: Coordinates = Coordinates(),
    val roverPosition: Coordinates = Coordinates(),
    val roverDirection: String = Direction.N.name,
    val movements: String = ""
)