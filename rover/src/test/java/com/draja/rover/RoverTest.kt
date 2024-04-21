package com.draja.rover

import com.draja.rover.domain.Rover
import com.draja.rover.entities.Coordinates
import com.draja.rover.entities.Direction
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class RoverTest {

    private lateinit var rover: Rover

    @Before
    fun setUp() {
        rover = Rover(Coordinates(5, 5), Coordinates(1, 2), Direction.N)
    }

    @Test
    fun testMoveForward() {
        rover.moveForward()
        assertEquals(Coordinates(1, 3), rover.getRoverPosition())
    }

    @Test
    fun testTurnLeft() {
        rover.turnLeft()
        assertEquals(Direction.W, rover.getRoverDirection())
    }

    @Test
    fun testTurnRight() {
        rover.turnRight()
        assertEquals(Direction.E, rover.getRoverDirection())
    }

    @Test
    fun testMoveForwardAtNorthBorder() {
        rover = Rover(Coordinates(5, 5), Coordinates(0, 5), Direction.N)
        rover.moveForward()
        assertEquals(Coordinates(0, 5), rover.getRoverPosition())
    }

    @Test
    fun testMoveForwardAtEastBorder() {
        rover = Rover(Coordinates(5, 5), Coordinates(5, 0), Direction.E)
        rover.moveForward()
        assertEquals(Coordinates(5, 0), rover.getRoverPosition())
    }

    @Test
    fun testMoveForwardAtSouthBorder() {
        rover = Rover(Coordinates(5, 5), Coordinates(0, 0), Direction.S)
        rover.moveForward()
        assertEquals(Coordinates(0, 0), rover.getRoverPosition())
    }

    @Test
    fun testMoveForwardAtWestBorder() {
        rover = Rover(Coordinates(5, 5), Coordinates(0, 0), Direction.W)
        rover.moveForward()
        assertEquals(Coordinates(0, 0), rover.getRoverPosition())
    }
}