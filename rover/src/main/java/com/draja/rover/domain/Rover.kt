package com.draja.rover.domain

import com.draja.rover.entities.Coordinates
import com.draja.rover.entities.Direction

class Rover(
    private val grid: Coordinates = Coordinates(),
    private var position: Coordinates = Coordinates(),
    private var direction: Direction = Direction.N
) : RoverInterface {

    override fun getRoverDirection(): Direction = direction

    override fun getRoverPosition(): Coordinates = position

    override fun moveForward() {
        when (direction) {
            Direction.N -> if (position.y < grid.y) position.y++
            Direction.E -> if (position.x < grid.x) position.x++
            Direction.S -> if (position.y > 0) position.y--
            Direction.W -> if (position.x > 0) position.x--
        }
    }

    override fun turnLeft() {
        direction = when (direction) {
            Direction.N -> Direction.W
            Direction.W -> Direction.S
            Direction.S -> Direction.E
            Direction.E -> Direction.N
        }
    }

    override fun turnRight() {
        direction = when (direction) {
            Direction.N -> Direction.E
            Direction.E -> Direction.S
            Direction.S -> Direction.W
            Direction.W -> Direction.N
        }
    }
}