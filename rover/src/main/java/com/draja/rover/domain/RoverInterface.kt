package com.draja.rover.domain

import com.draja.rover.entities.Coordinates
import com.draja.rover.entities.Direction

interface RoverInterface {
    fun getRoverPosition(): Coordinates
    fun getRoverDirection(): Direction
    fun moveForward()
    fun turnLeft()
    fun turnRight()
}